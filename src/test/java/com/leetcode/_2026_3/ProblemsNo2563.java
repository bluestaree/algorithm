package com.leetcode._2026_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2563. 统计公平数对的数目
 *
 * @author DHW
 * @date 2026/3/11 9: 34
 * @Version 1.0
*/
public class ProblemsNo2563 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,2,3,3};
        int lower = 5;
        int upper = 5;
        System.out.println("res = " + countFairPairs(nums, lower, upper));
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return count(nums, upper) - count(nums, lower - 1);
    }

    private long count(int[] nums, int upper) {
        long res = 0;
        int j = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while(j > i && nums[i] + nums[j] > upper) {
                j--;
            }
            if(j == i) {
                break;
            }
            res += j - i;
        }
        return res;
    }

}

