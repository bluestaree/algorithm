package com.leetcode._2023_3;

import org.junit.Test;

import java.util.HashSet;


/**
 * 2367. 算术三元组的数目
 *
 * @author DHW
 * @date 2023/3/31 13:56
 * @Version 1.0
*/
public class ProblemsNo2367 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,3};
        int diff = 0;
        System.out.println("res = " + arithmeticTriplets(nums, diff));
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;
        int len = nums.length;
        int[] index = new int[nums[len - 1] + 1];
        for (int i = 0; i < nums.length; i++) {
            index[nums[i]] = 1;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int num = nums[i];
            int maxIndex = num + (diff << 1);
            if(maxIndex >= index.length) {
                break;
            }
            if(index[num + diff] == 1 && index[num + (diff << 1)] == 1) {
                res++;
            }
        }
        return res;
    }
}
