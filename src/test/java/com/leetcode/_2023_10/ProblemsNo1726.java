package com.leetcode._2023_10;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;


/**
 * 1726. 同积元组
 *
 * @author DHW
 * @date 2023/10/19 9:16
 * @Version 1.0
*/
public class ProblemsNo1726 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,2,3,1};
        System.out.println("res = " + tupleSameProduct(nums));
    }

    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.merge(nums[i] * nums[j], 1, Integer::sum);
            }
        }
        int res = 0;
        for (Integer value : map.values()) {
            res += value * (value - 1 ) / 2;
        }
        return res << 3;
    }
}

