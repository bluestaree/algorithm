package com.leetcode._2023_2;

import org.junit.Test;

import java.util.HashMap;


/**
 * 2341. 数组能形成多少数对
 *
 * @author DHW
 * @date 2023/2/16 10:13
 * @Version 1.0
*/
public class ProblemsNo2341 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,3,2,1,3,2,2};
        System.out.println("res = " + numberOfPairs(nums));
    }

    public int[] numberOfPairs(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(count[num] == 1) {
                count[num] = 0;
                res[0] += 1;
            } else {
                count[num] = 1;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i] == 1) {
                res[1] += 1;
            }
        }
        return res;
    }
}
