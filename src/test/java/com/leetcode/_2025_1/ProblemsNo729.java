package com.leetcode._2025_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 729. 我的日程安排表 I
 *
 * @author DHW
 * @date 2022/1/2 9: 15
 * @Version 1.0
 */
public class ProblemsNo729 {

    @Test
    public void solution() {
        MyCalendar obj = new MyCalendar();
        boolean param_1 = obj.book(10, 20);
    }


    class MyCalendar {

        List<int[]> list = new ArrayList();
        public MyCalendar() {

        }

        public boolean book(int startTime, int endTime) {
            endTime--;
            for (int[] a : list) {
                if(startTime > a[1] || endTime < a[0]) {
                    continue;
                }
                return false;
            }
            list.add(new int[]{startTime, endTime});
            return true;
        }
    }
}

