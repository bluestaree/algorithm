package com.leetcode._2025_6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;


/**
 * 594. 最长和谐子序列
 *
 * @author DHW
 * @date 2025/6/30 9: 06
 * @Version 1.0
*/
public class ProblemsNo594 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,3,2,2,5,2,3,7};
        System.out.println("res = " + findLHS(nums));
    }

    public int findLHS(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int k = 1;
            int c = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] <= nums[i] + 1){
                    k++;
                    c = nums[j] - nums[i];
                } else {
                    break;
                }
            }
            if(c == 1) {
                ans = Math.max(ans, k);
            }
        }
        return ans;
    }
}

