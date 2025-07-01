package com.leetcode._2025_6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 2200. 找出数组中的所有 K 近邻下标
 *
 * @author DHW
 * @date 2025/6/24 9: 05
 * @Version 1.0
*/
public class ProblemsNo2200 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,1000,1,1000};
        int key = 1;
        int k = 1;
        System.out.println("res = " + findKDistantIndices(nums, key, k));
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int r = -1;

        for (int i = 0; i < nums.length; i++) {
            if(i <= r) {
                list.add(i);
            }
            if(nums[i] == key) {
                if(r == -1 || r < i) {
                    int j = Math.max(r + 1, i - k);
                    for (; j <= i ; j++) {
                        if(j >=0) {
                            list.add(j);
                        }
                    }
                }
                r = Math.min(i + k, nums.length - 1);
            }
        }

        return list;
    }
}

