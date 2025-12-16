package com.leetcode._2025_11;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 1437. 是否所有 1 都至少相隔 k 个元素
 *
 * @author DHW
 * @date 2025/11/17 8: 43
 * @Version 1.0
*/
public class ProblemsNo1437 {

    @Test
    public void solution() {
        int[] nums =  new int[]{1,0,0,0,1,0,0,1};
        int k = 2;
        System.out.println("res = " + kLengthApart(nums, k));
    }

    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int pre = -k;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                if(i - pre - 1 < k) {
                    return false;
                }
                pre = i;
            }
        }
        return true;
    }

}

