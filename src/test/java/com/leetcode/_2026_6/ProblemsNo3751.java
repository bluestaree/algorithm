package com.leetcode._2026_6;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3751. 范围内总波动值 I
 *
 * @author DHW
 * @date 2026/6/4 8: 52
 * @Version 1.0
 */
public class ProblemsNo3751 {

    @Test
    public void solution() {
        int num1 = 2;
        int num2 = 2;
        System.out.println("= res = " + totalWaviness(num1, num2));
    }

    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for (int i = num1; i <= num2; i++) {
            ans += getTotalWaviness(i);
        }
        return ans;
    }

    private int getTotalWaviness(int num) {
        String numStr = String.valueOf(num);
        int n = numStr.length();
        if(n < 3) {
            return 0;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = numStr.charAt(i) - '0';
        }
        int cnt = 0;
        for (int i = 1; i < n - 1; i++) {
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                cnt++;
            } else if(nums[i] < nums[i + 1] && nums[i] < nums[i - 1]) {
                cnt++;
            }
        }
        return cnt;
    }
}

