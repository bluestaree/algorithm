package com.leetcode._2025_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 90. 子集 II
 *
 * @author DHW
 * @date 2025/2/5 8: 52
 * @Version 1.0
*/
public class ProblemsNo90 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,6};
        System.out.println("res = " + subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        backtrack(0, nums, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int index, int[] nums, List<List<Integer>> res, List temp) {
        res.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i-1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(i+1, nums, res, temp);
            temp.remove(temp.size()-1);
        }
    }
}

