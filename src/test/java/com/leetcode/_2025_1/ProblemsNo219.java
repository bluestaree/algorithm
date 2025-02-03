package com.leetcode._2025_1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * 219. 存在重复元素 II
 *
 * @author DHW
 * @date 2025/1/29 10: 54
 * @Version 1.0
*/
public class ProblemsNo219 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,3,1,1,4};
        int k = 3;
        System.out.println("res = " + containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - map.getOrDefault(nums[i], -1000000) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}

