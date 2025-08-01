package com.leetcode._2025_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 3169. 无需开会的工作日
 *
 * @author DHW
 * @date 2025/7/11 9: 23
 * @Version 1.0
*/
public class ProblemsNo3169 {

    @Test
    public void solution() {
        int days = 10;
        int[][] meetings = new int[][]{new int[]{5,7},new int[]{1,3},new int[]{9,10}};
        System.out.println("res = " + countDays(days, meetings));
    }

    public int countDays(int days, int[][] meetings) {
        int res = 0;
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        res += meetings[0][0] - 1;
        int r = meetings[0][1];
        for (int i = 1; i < meetings.length; i++) {
            if(meetings[i][0] > r + 1) {
                res += meetings[i][0] - r - 1;
                r = meetings[i][1];
                continue;
            }
            if((meetings[i][1] >  r)) {
                r = meetings[i][1];
            }
        }
        res += days - r;
        return res;
    }

}

