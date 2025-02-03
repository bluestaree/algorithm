package com.leetcode._2025_1;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;


/**
 * 732. 我的日程安排表 III
 *
 * @author DHW
 * @date 2025/1/4 10: 35
 * @Version 1.0
 */
public class ProblemsNo732 {

    @Test
    public void solution() {
        MyCalendarThree obj = new MyCalendarThree();
        int param_1 = obj.book(10, 20);

    }

    class MyCalendarThree {

        TreeMap<Integer, Integer> map;

        public MyCalendarThree() {
            map = new TreeMap<>();
        }

        public int book(int startTime, int endTime) {
            int num = 0;
            int max = 0;
            map.put(startTime, map.getOrDefault(startTime, 0) + 1);
            map.put(endTime, map.getOrDefault(endTime, 0) - 1);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                max += entry.getValue();
                num = Math.max(max, num);

            }
            return num;
        }

    }
}

