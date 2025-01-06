package com.leetcode._2025_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * 731. 我的日程安排表 II
 *
 * @author DHW
 * @date 2022/1/3 8: 47
 * @Version 1.0
 */
public class ProblemsNo731 {

    @Test
    public void solution() {
        MyCalendarTwo obj = new MyCalendarTwo();
        boolean param_1 = obj.book(10, 20);
    }


    class MyCalendarTwo {

        TreeMap<Integer , Integer> map;
        public MyCalendarTwo() {
            map = new TreeMap<>();
        }

        public boolean book(int startTime, int endTime) {
            int max = 0;
            map.put(startTime , map.getOrDefault(startTime , 0) + 1);
            map.put(endTime , map.getOrDefault(endTime , 0) - 1);
            for(Map.Entry<Integer , Integer> entry : map.entrySet()){
                max += entry.getValue();
                if(max > 2){
                    map.put(startTime , map.getOrDefault(startTime , 0) - 1);
                    map.put(endTime , map.getOrDefault(endTime , 0) + 1);
                    return false;
                }
            }
            return true;
        }
    }
}

