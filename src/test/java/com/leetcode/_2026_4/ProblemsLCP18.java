package com.leetcode._2026_4;

import org.junit.Test;

import java.util.Arrays;


/**
 * LCP 18. 早餐组合
 *
 * @author DHW
 * @date 2026/4/8 9: 13
 * @Version 1.0
 */
public class ProblemsLCP18 {

    @Test
    public void solution() {
        int[] staple = new int[]{3,5,2,6};
        int[] drinks = new int[]{10,10,15,12};
        int x = 1;
        breakfastNumber(staple, drinks, x);
    }

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int mod = 1_000_000_007;
        int ans = 0;
        int left = 0;
        int right = drinks.length - 1;
        while (left < staple.length && right >= 0) {
            if(staple[left] + drinks[right] <= x) {
                ans = (ans + right + 1) % mod;
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

}

