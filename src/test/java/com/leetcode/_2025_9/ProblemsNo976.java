package com.leetcode._2025_9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 976. 三角形的最大周长
 *
 * @author DHW
 * @date 2025/9/28 9: 35
 * @Version 1.0
*/
public class ProblemsNo976 {

    @Test
    public void solution() {
        int[] nums =  new int[]{3,3,3,1,2,1,1,2,3,3,4};
        System.out.println("res = " + largestPerimeter(nums));
    }

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int c = nums[i - 1] + nums[i - 2];
            if (c > nums[i]) {
                return c + nums[i];
            }
        }
        return 0;
    }

}

