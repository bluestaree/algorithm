package com.leetcode._2023_8;

import org.junit.Test;

import java.util.HashSet;


/**
 * 849. 到最近的人的最大距离
 *
 * @author DHW
 * @date 2023/8/22 9:09
 * @Version 1.0
*/
public class ProblemsNo849 {

    @Test
    public void solution() {
        int[] seats = new int[]{1,0,0,0};
        System.out.println("res = " + maxDistToClosest(seats));
    }

    public int maxDistToClosest(int[] seats) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            if(seats[i] == 0) {
                count++;
            } else if(count > 0) {
                if(res == 0 && seats[0] == 0) {
                    res = count;
                } else {
                    res = Math.max(res, (count + 1) >> 1);
                }
                count = 0;
            }
        }
        if(count > 0) {
            res = Math.max(res, count);
        }
        return res;
    }
}
