package com.leetcode._2025_12;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;


/**
 * 2461. 长度为 K 子数组中的最大和
 *
 * @author DHW
 * @date 2025/12/3 13: 56
 * @Version 1.0
*/
public class ProblemsNo2461 {

    @Test
    public void solution() {
        int[] nums =  new int[]{3,1,2,1};
        int k = 2;
        System.out.println("res = " + maximumSubarraySum(nums, k));
    }

    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int l = i - k + 1;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(l < 0) {
                continue;
            }
            if(map.keySet().size() == k) {
                ans = Math.max(ans, sum);
            }
            sum -= nums[l];
            int val = map.get(nums[l]);
            if(val == 1) {
                map.remove(nums[l]);
            } else {
                map.put(nums[l], val - 1);
            }
        }
        return ans;
    }

}

