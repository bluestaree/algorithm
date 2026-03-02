package com.leetcode._2026_2;

import org.junit.Test;

import java.util.HashSet;


/**
 * 3719. 最长平衡子数组 I
 *
 * @author DHW
 * @date 2026/2/10 9: 11
 * @Version 1.0
*/
public class ProblemsNo3719 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,0,1,0,1};
        System.out.println("res = " + longestBalanced(nums));
    }


    public int longestBalanced(int[] nums) {
        int ans = 0;
        for (int l = 0; l < nums.length; l++) {
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();
            for (int r = l; r < nums.length; r++) {
                if (nums[r] % 2 == 0) {
                    set1.add(nums[r]);
                } else {
                    set2.add(nums[r]);
                }
                if (set1.size() == set2.size()) {
                    ans = Math.max(ans, r - l + 1);
                }
            }
        }
        return ans;
    }

}

