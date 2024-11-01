package com.leetcode._2024_10;

import org.junit.Test;

import java.util.HashSet;


/**
 * 3158. 求出出现两次数字的 XOR 值
 *
 * @author DHW
 * @date 2024/10/12 8:53
 * @Version 1.0
*/
public class ProblemsNo3158 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,8,2,8};
        System.out.println("res = " + duplicateNumbersXOR(nums));
    }

    public int duplicateNumbersXOR(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)) {
                res ^= num;
            }
        }
        return res;
    }
}

