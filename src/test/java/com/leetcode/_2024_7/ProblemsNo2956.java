package com.leetcode._2024_7;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 2956. 找到两个数组中的公共元素
 *
 * @author DHW
 * @date 2024/7/16 9:27
 * @Version 1.0
*/
public class ProblemsNo2956 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{4,8,2,8};
        int[] nums2 = new int[]{4,8,2,8};
        System.out.println("res = " + findIntersectionValues(nums1, nums2));
    }

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        int[] res = new int[2];
        for (int i : nums1) {
            if(set2.contains(i)) {
                res[0]++;
            }
        }
        for (int i : nums2) {
            if(set1.contains(i)) {
                res[1]++;
            }
        }
        return res;
    }
}

