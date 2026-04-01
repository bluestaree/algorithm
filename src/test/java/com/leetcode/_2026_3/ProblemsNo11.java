package com.leetcode._2026_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 11. 盛最多水的容器
 *
 * @author DHW
 * @date 2026/3/20 10: 06
 * @Version 1.0
*/
public class ProblemsNo11 {

    @Test
    public void solution() {
        int[] height = new int[]{2,2,3,3};
        System.out.println("res = " + maxArea(height));
    }


    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

}

