package com.leetcode._2026_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 15. 三数之和
 *
 * @author DHW
 * @date 2026/3/11 11: 34
 * @Version 1.0
*/
public class ProblemsNo15 {

    @Test
    public void solution() {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println("res = " + threeSum(nums));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int x = nums[i];
            if(i > 0 && x == nums[i - 1]) {
                continue;
            }
            if(x + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            if(x + nums[nums.length - 2] + nums[nums.length - 1] < 0) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int num = x + nums[j] + nums[k];
                if (num > 0) {
                    k--;
                } else if (num < 0) {
                    j++;
                } else {
                    ans.add(Arrays.asList(x, nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                }
            }
        }
        return ans;
    }

}

