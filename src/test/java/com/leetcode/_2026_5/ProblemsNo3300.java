package com.leetcode._2026_5;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 3300. 替换为数位和以后的最小元素
 *
 * @author DHW
 * @date 2026/5/29 8: 32
 * @Version 1.0
 */
public class ProblemsNo3300 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,3,54,4,7};
        System.out.println("res = " + minElement(nums));
    }

    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int num : nums) {
            int n = num;
            while(num > 0) {
                n += num % 10;
                num /= 10;
            }
            ans = Math.min(ans, n);
        }
        return ans;
    }

}

