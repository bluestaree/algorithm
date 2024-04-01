package com.leetcode._2024_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * 2917. 找出数组中的 K-or 值
 *
 * @author DHW
 * @date 2024/3/6 10:01
 * @Version 1.0
*/
public class ProblemsNo2917 {

    @Test
    public void solution() {
        int k = 6;
        int[] nums = new int[]{4,2,1};
        System.out.println("res = " + findKOr(nums, k));
    }

    public int findKOr(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < 31; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if((nums[j] >> i & 1) == 1 ) {
                    count++;
                }
            }
            if(count >= k) {
                res |= 1 << i;
            }
        }
        return res;
    }

}

