package com.leetcode._2024_1;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;


/**
 * 2670. 找出不同元素数目差数组
 *
 * @author DHW
 * @date 2024/1/31 9:11
 * @Version 1.0
*/
public class ProblemsNo2670 {

    @Test
    public void solution() {
        int[] nums = new int[]{10,6,8,5,11,9};
        System.out.println("res = " + distinctDifferenceArray(nums));
    }

    public int[] distinctDifferenceArray(int[] nums) {
        int len = nums.length;
        int[] count = new int[len + 1];
        int[] res = new int[len];
        HashSet<Integer> set = new HashSet<>();
        for (int i = len - 1; i > 0; i--) {
            set.add(nums[i]);
            count[i] = set.size();
        }
        set.clear();
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
            res[i] = set.size() - count[i+1];
        }
        return res;
    }
}

