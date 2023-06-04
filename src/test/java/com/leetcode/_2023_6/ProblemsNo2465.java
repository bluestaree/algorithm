package com.leetcode._2023_6;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 2465. 不同的平均值数目
 *
 * @author DHW
 * @date 2023/6/4 11:19
 * @Version 1.0
*/
public class ProblemsNo2465 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,1,4,0,3,5};

        System.out.println("res = " + distinctAverages(nums));
    }

    public int distinctAverages(int[] nums) {
        HashSet<Double> set = new HashSet<>();
        Arrays.sort(nums);
        int step = 1;
        while (true) {
            if(step - 1 >= nums.length - step) {
                break;
            }
            double sum = nums[step - 1] + nums[nums.length - step];
            set.add(sum / 2);
            step++;
        }
        return set.size();
    }
}
