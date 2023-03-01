package com.leetcode._2023_2;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * 2357. 使数组中所有元素都等于零
 *
 * @author DHW
 * @date 2023/2/24 10:29
 * @Version 1.0
*/
public class ProblemsNo2357 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,5,0,3,5};
        System.out.println("res = " + minimumOperations(nums));
    }

    public int minimumOperations(int[] nums) {
        int res = 0;
        int x = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 || nums[i] - x == 0) {
                continue;
            }
            x += nums[i] - x;
            res++;
        }
        return res;
    }
}
