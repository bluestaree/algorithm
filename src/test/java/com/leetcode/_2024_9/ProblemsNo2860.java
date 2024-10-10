package com.leetcode._2024_9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 2860. 让所有学生保持开心的分组方法数
 *
 * @author DHW
 * @date 2024/9/4 9:29
 * @Version 1.0
*/
public class ProblemsNo2860 {

    @Test
    public void solution() {
        List<Integer> nums = Arrays.asList(6,0,3,3,6,7,2,7);
        System.out.println("res = " + countWays(nums));
    }

    public int countWays(List<Integer> nums) {
        int res = 0;
        Collections.sort(nums);
        int len = nums.size();
        for (int i = 0; i<= len; i++) {
            if((i == len || nums.get(i) > i) && (i == 0 || nums.get(i - 1) < i)) {
                res++;
            }
        }
        return res;
    }
}

