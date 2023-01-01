package com.leetcode._2022_12;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2037. 使每位学生都有座位的最少移动次数
 *
 * @author DHW
 * @date 2022/12/31 13:15
 * @Version 1.0
*/
public class ProblemsNo2037 {

    @Test
    public void solution() {
        int[] seats = new int[]{12,14,19,19,12};
        int[] students = new int[]{19,2,17,20,7};
        System.out.println("res = " + minMovesToSeat(seats, students));
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }
}
