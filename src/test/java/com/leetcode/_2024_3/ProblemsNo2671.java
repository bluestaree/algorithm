package com.leetcode._2024_3;

import org.junit.Test;

import java.util.*;


/**
 * 2671. 频率跟踪器
 *
 * @author DHW
 * @date 2024/3/21 9:03
 * @Version 1.0
*/
public class ProblemsNo2671 {

    @Test
    public void solution() {
        FrequencyTracker obj = new FrequencyTracker();
        obj.add(1);
        obj.deleteOne(1);
        boolean param_3 = obj.hasFrequency(1);
        System.out.println("res = " + param_3);
    }

    class FrequencyTracker {

        private Map<Integer, Integer> m1 = new HashMap();
        private Map<Integer, Integer> m2 = new HashMap();

        public FrequencyTracker() {

        }

        public void add(int number) {
            update(number, 1);
        }

        public void deleteOne(int number) {
            Integer old = m1.getOrDefault(number, 0);
            if(old > 0) {
                update(number, -1);
            }
        }

        private void update(int number, Integer num) {
            Integer i = m1.getOrDefault(number, 0);
            m1.put(number, i + num);
            m2.put(i, m2.getOrDefault(i, 0) - 1);
            m2.put(i + num, m2.getOrDefault(i + num, 0) + 1);
        }

        public boolean hasFrequency(int frequency) {
            return m2.getOrDefault(frequency, 0) > 0;
        }
    }

}

