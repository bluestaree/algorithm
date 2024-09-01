package com.leetcode._2024_9;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1450. 在既定时间做作业的学生人数
 *
 * @author DHW
 * @date 2024/9/1 10:35
 * @Version 1.0
*/
public class ProblemsNo1450 {

    @Test
    public void solution() {
        int[] startTime = new int[]{4,8,2,8};
        int[] endTime = new int[]{4,8,2,8};
        int queryTime = 4;
        System.out.println("res = " + busyStudent(startTime, endTime, queryTime));
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            if(startTime[i] <= queryTime && endTime[i] >= queryTime) {
                res++;
            }
        }
        return res;
    }
}

