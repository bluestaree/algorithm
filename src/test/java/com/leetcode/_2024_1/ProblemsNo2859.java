package com.leetcode._2024_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 2859. 计算 K 置位下标对应元素的和
 *
 * @author DHW
 * @date 2024/1/25 9:33
 * @Version 1.0
*/
public class ProblemsNo2859 {

    @Test
    public void solution() {
        List<Integer> nums = new ArrayList<>();
        nums.add(6);
        nums.add(5);
        nums.add(3);
        nums.add(9);
        nums.add(2);
        nums.add(7);
        System.out.println("res = " + sumIndicesWithKSetBits(nums, 5));
    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            if(bitCount(i) == k) {
                res += nums.get(i);
            }
        }
        return res;
    }

    private int bitCount(int num) {
        int count = 0;
        while(num != 0) {
            count += (num % 2);
            num /= 2;
        }
        return count;
    }
}

