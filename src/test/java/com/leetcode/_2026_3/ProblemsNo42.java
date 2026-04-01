package com.leetcode._2026_3;

import com.sun.deploy.panel.JHighDPITable;
import org.junit.Test;


/**
 * 42. 接雨水
 *
 * @author DHW
 * @date 2026/3/20 10: 28
 * @Version 1.0
*/
public class ProblemsNo42 {

    @Test
    public void solution() {
        int[] height = new int[]{0};
        System.out.println("res = " + trap(height));
    }


    public int trap(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int lh = height[left], rh = height[right];
        while (left < right) {
            lh = Math.max(lh, height[left]);
            rh = Math.max(rh, height[right]);
            if(lh <= rh) {
                ans += Math.max(0, lh - height[left]);
                left++;
            } else {
                ans += Math.max(0, rh - height[right]);
                right--;
            }
        }
        return ans;
    }

}

