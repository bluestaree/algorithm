package com.leetcode._2025_10;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3354. 使数组元素等于零
 *
 * @author DHW
 * @date 2025/10/28 8: 56
 * @Version 1.0
*/
public class ProblemsNo3354 {

    @Test
    public void solution() {
        int[] nums =  new int[]{1,0,2,0,3};
        System.out.println("res = " + countValidSelections(nums));
    }

    public int countValidSelections(int[] nums) {
        int s = Arrays.stream(nums).sum();
        int ans = 0, l = 0;
        for (int x : nums) {
            if (x != 0) {
                l += x;
            } else if (l * 2 == s) {
                ans += 2;
            } else if (Math.abs(l * 2 - s) <= 1) {
                ++ans;
            }
        }
        return ans;
    }

}

