package com.leetcode._2026_4;

import org.junit.Test;


/**
 * 485. 最大连续 1 的个数
 *
 * @author DHW
 * @date 2026/4/13 8: 42
 * @Version 1.0
 */
public class ProblemsNo485 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,1,0,1,1,11};
        System.out.println("sortArrayByParity(nums) = " + findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                cnt = 0;
            } else {
                cnt++;
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}

