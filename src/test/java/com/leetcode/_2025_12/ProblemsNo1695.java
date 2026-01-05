package com.leetcode._2025_12;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;


/**
 * 1695. 删除子数组的最大得分
 *
 * @author DHW
 * @date 2025/12/23 9: 43
 * @Version 1.0
*/
public class ProblemsNo1695 {

    @Test
    public void solution() {
        int[] nums =  new int[]{5,2,1,2,5,2,1,2,5};
        System.out.println("res = " + maximumUniqueSubarray(nums));
    }

    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0;
        int left = 0;
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            while(set.contains(nums[i])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(nums[i]);
            sum += nums[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

