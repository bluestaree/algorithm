package com.leetcode._2025_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 47. 全排列 II
 *
 * @author DHW
 * @date 2025/2/6 9: 03
 * @Version 1.0
*/
public class ProblemsNo47 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,6};
        System.out.println("res = " + permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length == 0) return list;
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        backtrack(nums, list, new ArrayList<>(), flag);
        return list;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] flag) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if(flag[i]) {
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && !flag[i-1]) {
                continue;
            }
            temp.add(nums[i]);
            flag[i] = true;
            backtrack( nums, res, temp, flag);
            flag[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}

