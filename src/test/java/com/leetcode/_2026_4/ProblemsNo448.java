package com.leetcode._2026_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 448. 找到所有数组中消失的数字
 *
 * @author DHW
 * @date 2026/4/1 10: 24
 * @Version 1.0
 */
public class ProblemsNo448 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println("sortArrayByParity(nums) = " + findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}

