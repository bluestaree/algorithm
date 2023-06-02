package com.leetcode._2023_5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 2455. 可被三整除的偶数的平均值
 *
 * @author DHW
 * @date 2023/5/29 14:47
 * @Version 1.0
*/
public class ProblemsNo2455 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,4,9,10};

        System.out.println("res = " + averageValue(nums));
    }

    public int averageValue(int[] nums) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 6 == 0) {
                sum += nums[i];
                count++;
            }
        }
        return count > 0 ? sum / count : 0;
    }
}
