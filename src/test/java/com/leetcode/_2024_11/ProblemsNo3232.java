package com.leetcode._2024_11;

import org.junit.Test;


/**
 * 3232. 判断是否可以赢得数字游戏
 *
 * @author DHW
 * @date 2024/11/30 10: 33
 * @Version 1.0
*/
public class ProblemsNo3232 {

    @Test
    public void solution() {
        int[] nums = new int[]{7,4,1};
        System.out.println("res = " + canAliceWin(nums));
    }

    public boolean canAliceWin(int[] nums) {
        int a = 0; int b= 0;
        for (int num : nums) {
            if(num < 10) {
                a += num;
            } else {
                b += num;
            }
        }
        return a != b;
    }
}

