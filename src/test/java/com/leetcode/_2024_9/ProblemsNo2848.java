package com.leetcode._2024_9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * 2848. 与车相交的点
 *
 * @author DHW
 * @date 2024/9/15 10: 35
 * @Version 1.0
*/
public class ProblemsNo2848 {

    @Test
    public void solution() {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> nums1 = new ArrayList<>();
        nums1.add(3);
        nums1.add(6);
        List<Integer> nums2 = new ArrayList<>();
        nums2.add(1);
        nums2.add(5);
        List<Integer> nums3 = new ArrayList<>();
        nums3.add(4);
        nums3.add(7);
        nums.add(nums1);
        nums.add(nums2);
        nums.add(nums3);
        System.out.println("res = " + numberOfPoints(nums));
    }

    public int numberOfPoints(List<List<Integer>> nums) {
        HashSet<Integer> set = new HashSet<>();
        for (List<Integer> num : nums) {
            for (int i = num.get(0); i <= num.get(1); i++) {
                set.add(i);
            }
        }
        return set.size();
    }
}

