package com.leetcode._2024_10;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 3194. 最小元素和最大元素的最小平均值
 *
 * @author DHW
 * @date 2024/10/16 8:33
 * @Version 1.0
*/
public class ProblemsNo3194 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,9,8,3,10,5};
        System.out.println("res = " + minimumAverage(nums));
    }

    public double minimumAverage(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        double res = Double.MAX_VALUE;
        Arrays.sort(nums);
        while(l < r) {
            res = Math.min(res, (nums[l] + nums[r]) / 2.0);
            l++;
            r--;
        }
        return res;
    }
}

