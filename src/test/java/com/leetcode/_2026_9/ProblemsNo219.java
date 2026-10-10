package com.leetcode._2026_9;

import org.junit.Test;

import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 219. 存在重复元素 II
 *
 * @author DHW
 * @date 2026/9/29 9:24
 * @Version 1.0
*/
public class ProblemsNo219 {

    @Test
    public void solution() {
        int[] nums = new int[]{93,93};
        int k = 1;
        System.out.println("res = " + containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}

