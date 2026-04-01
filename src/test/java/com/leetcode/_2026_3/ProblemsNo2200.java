package com.leetcode._2026_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 2200. 找出数组中的所有 K 近邻下标
 *
 * @author DHW
 * @date 2026/3/24 9: 46
 * @Version 1.0
 */
public class ProblemsNo2200 {

    @Test
    public void solution() {
        int[] nums = new int[]{8,7,1};
        int key = 11;
        int k = 2;
        System.out.println("res = " + findKDistantIndices(nums, key, k));
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int l = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == key) {
                for (int j = Math.max(0, i - k); j <= Math.min(nums.length - 1, i + k); j++) {
                    if(j > l) {
                        list.add(j);
                    }
                }
                l = i + k;
            }
        }
        return list;
    }

}

