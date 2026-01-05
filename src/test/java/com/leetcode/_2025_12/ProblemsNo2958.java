package com.leetcode._2025_12;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;


/**
 * 2958. 最多 K 个重复元素的最长子数组
 *
 * @author DHW
 * @date 2025/12/24 9: 43
 * @Version 1.0
*/
public class ProblemsNo2958 {

    @Test
    public void solution() {
        int[] nums =  new int[]{5,2,1,2,5,2,1,2,5};
        int k = 2;
        System.out.println("res = " + maxSubarrayLength(nums, k));
    }

    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

