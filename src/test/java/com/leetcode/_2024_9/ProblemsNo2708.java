package com.leetcode._2024_9;

import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 2708. 一个小组的最大实力值
 *
 * @author DHW
 * @date 2024/9/3 9:29
 * @Version 1.0
*/
public class ProblemsNo2708 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,8,2,8};
        System.out.println("res = " + maxStrength(nums));
    }

    public long maxStrength(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        long res = 0;
        int maxB = -10;
        for (int num : nums) {
            if(num > 0) {
                res = 1;
                a.add(num);
            } else if(num < 0) {
                b.add(num);
                maxB = Math.max(maxB, num);
            }
        }
        for (Integer num : a) {
            res *= num;
        }
        if(res == 0) {
            if(b.size() < 2) {
                return 0;
            }
            res = 1;
        }
        for (Integer num : b) {
            res *= num;
        }
        if(res < 0) {
            return res / maxB;
        }
        return res;
    }
}

