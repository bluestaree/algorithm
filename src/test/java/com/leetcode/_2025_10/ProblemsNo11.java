package com.leetcode._2025_10;

import org.junit.Test;


/**
 * 11. 盛最多水的容器
 *
 * @author DHW
 * @date 2025/10/4 11: 25
 * @Version 1.0
*/
public class ProblemsNo11 {

    @Test
    public void solution() {
        int[] height =  new int[]{4,2,5};
        System.out.println("res = " + maxArea(height));
    }

    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}

