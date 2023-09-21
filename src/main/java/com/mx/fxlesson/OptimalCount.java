package com.mx.fxlesson;


import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class OptimalCount {
    private Integer LAKH = 100000;
    private BigDecimal LAKH_FOLD = BigDecimal.valueOf(LAKH);

    public List<DataVo> optimalCount(DataDto dto) {
        // 传值整理
        BigDecimal target = dto.getTarget().setScale(2, BigDecimal.ROUND_HALF_UP);
        List<BigDecimal> group1 = convertToGroup(dto.getGroup1());
        List<BigDecimal> group2 = convertToGroup(dto.getGroup2());
        BigDecimal count1 = group1.stream().reduce((d1, d2) -> d1.add(d2)).get();
        BigDecimal count2 = group2.stream().reduce((d1, d2) -> d1.add(d2)).get();
        boolean count1GreaterCount2 = count1.compareTo(count2) >= 0;
        List<BigDecimal> maxGroup = count1GreaterCount2 ? group1 : group2;
        List<BigDecimal> minGroup = count1GreaterCount2 ? group2 : group1;
        // 分片
        int i = 0;
        do {
            i++;
        } while (getSum(maxGroup, i).compareTo(target) < 0);
        int step = i / 4;
        // 分片筛选
        List<DataVo> dataVos = new LinkedList<>();
        CallableImple call1 = new CallableImple(target, maxGroup, minGroup, 0, step - 1);
        CallableImple call2 = new CallableImple(target, maxGroup, minGroup, step, step * 2 - 1);
        CallableImple call3 = new CallableImple(target, maxGroup, minGroup, step * 2, step * 3 - 1);
        CallableImple call4 = new CallableImple(target, maxGroup, minGroup, step * 3, step * 4 - 1);
        CallableImple call5 = new CallableImple(target, maxGroup, minGroup, step * 4, i - 1);
        dataVos.addAll(call1.call());
        dataVos.addAll(call2.call());
        dataVos.addAll(call3.call());
        dataVos.addAll(call4.call());
        dataVos.addAll(call5.call());
        // 近似值筛选
        dataVos = dataVos.stream().sorted(Comparator.comparing(DataVo::getCount)).collect(Collectors.toList());
        int length = dataVos.size();
        int offset = 0;
        for (; offset < length - 1; offset++) {
            if (dataVos.get(offset).getCount().compareTo(dataVos.get(offset + 1).getCount()) != 0) {
                break;
            }
        }
        return dataVos.subList(0, offset + 1);
    }

    private List<BigDecimal> convertToGroup(Object[] numbers) {
        List<BigDecimal> group = new ArrayList<>(numbers.length);
        for (Object num : numbers) {
            group.add(BigDecimal.valueOf(Double.parseDouble(Objects.toString(num))));
        }
        return group;
    }

    private BigDecimal getSum(List<BigDecimal> g, int r) {
        // 单项率舍入累加 (#.##)
        return g.stream().map(i -> i.multiply(BigDecimal.valueOf(r)).divide(LAKH_FOLD).setScale(2, BigDecimal.ROUND_HALF_UP)).reduce((d1, d2) -> d1.add(d2)).get();
    }

    /**
     * 分片执行
     */
    private class CallableImple implements Callable {
        private BigDecimal target;
        private List<BigDecimal> group1;
        private List<BigDecimal> group2;
        private int range1;
        private int range2;

        public CallableImple(BigDecimal target, List<BigDecimal> group1, List<BigDecimal> group2, int range1, int range2) {
            this.target = target;
            this.group1 = group1;
            this.group2 = group2;
            this.range1 = range1;
            this.range2 = range2;
        }

        @Override
        public List<DataVo> call() {
            int rate2 = 0;
            List<DataVo> dataVos = new LinkedList<>();
            BigDecimal sum1;
            BigDecimal sum2;
            for (; range1 <= range2; ) {
                sum1 = getSum(group1, range2);
                sum2 = getSum(group2, rate2);
                for (; sum1.add(sum2).compareTo(target) < 0 && rate2 < LAKH; ) {
                    rate2++;
                    sum2 = getSum(group2, rate2);
                }
                if (rate2 >= LAKH) {
                    break;
                }
                dataVos.add(new DataVo(sum1.add(sum2),
                        BigDecimal.valueOf(range2).divide(LAKH_FOLD),
                        BigDecimal.valueOf(rate2).divide(LAKH_FOLD)));
                range2--;
            }
            return dataVos;
        }
    }

    public static class DataDto {
        private BigDecimal target;
        private Object[] group1;
        private Object[] group2;

        public DataDto(BigDecimal target, Object[] group1, Object[] group2) {
            this.target = target;
            this.group1 = group1;
            this.group2 = group2;
        }

        public BigDecimal getTarget() {
            return target;
        }

        public void setTarget(BigDecimal target) {
            this.target = target;
        }

        public Object[] getGroup1() {
            return group1;
        }

        public void setGroup1(Object[] group1) {
            this.group1 = group1;
        }

        public Object[] getGroup2() {
            return group2;
        }

        public void setGroup2(Object[] group2) {
            this.group2 = group2;
        }
    }

    public static class DataVo {
        private BigDecimal count;
        private BigDecimal maxGroupRate;
        private BigDecimal minGroupRate;

        public DataVo(BigDecimal count, BigDecimal maxGroupRate, BigDecimal minGroupRate) {
            this.count = count;
            this.maxGroupRate = maxGroupRate;
            this.minGroupRate = minGroupRate;
        }

        public BigDecimal getCount() {
            return count;
        }

        public void setCount(BigDecimal count) {
            this.count = count;
        }

        public BigDecimal getMaxGroupRate() {
            return maxGroupRate;
        }

        public void setMaxGroupRate(BigDecimal maxGroupRate) {
            this.maxGroupRate = maxGroupRate;
        }

        public BigDecimal getMinGroupRate() {
            return minGroupRate;
        }

        public void setMinGroupRate(BigDecimal minGroupRate) {
            this.minGroupRate = minGroupRate;
        }

        @Override
        public String toString() {
            return String.format("近似预值-最大组倍率-最小组倍率：%s - %s - %s", count.toString(), maxGroupRate.toString(), minGroupRate.toString());
        }
    }
}

