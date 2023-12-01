package com.leetcode._2023_11;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 2824. 统计和小于目标的下标对数目
 *
 * @author DHW
 * @date 2023/11/24 9:10
 * @Version 1.0
*/
public class ProblemsNo2824 {

    @Test
    public void solution() {
        Integer[] nums = new Integer[]{-6,2,5,-2,-7,-1,3};
        int target = -2;
        System.out.println("res = " + countPairs(Arrays.asList(nums), target));
    }
    public int countPairs(List<Integer> nums, int target) {
        int res = 0;
        int len = nums.size();
        Collections.sort(nums);
        for (int i = 0; i < len - 1;i++) {
            int index = checkNum(nums, nums.get(i), i + 1, len - 1, target);
            res += (index - i - 1);
        }
        return res;
    }

    private int checkNum(List<Integer> nums, int num, int left, int right, int target) {
        if(left > right) {
            return left;
        }
        int mid = (right + left) >> 1;
        if(nums.get(mid) + num < target) {
            return checkNum(nums, num, mid + 1, right, target);
        } else {
            return checkNum(nums, num, left, mid - 1, target);
        }
    }
}

