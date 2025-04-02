package com.leetcode._2025_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 2597. 美丽子集的数目
 *
 * @author DHW
 * @date 2025/3/7 8: 48
 * @Version 1.0
*/
public class ProblemsNo2597 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,6};
        int k = 0;
        System.out.println("res = " + beautifulSubsets(nums, k));
    }

    List<Integer> temp = new ArrayList<Integer>();

    int res = 0;

    public int beautifulSubsets(int[] nums, int k) {
        travel(nums, k, 0);
        return res;
    }

    private void travel(int[] nums, int k, int i) {
        if(i == nums.length) {
            return;
        }
        temp.add(nums[i]);
        boolean flag = false;
        for (Integer integer : temp) {
            if(Math.abs(integer - nums[i]) == k) {
                flag = true;
                break;
            }
        }
        if(!flag) {
            res++;
            travel(nums, k, i + 1);
            temp.remove(temp.size() - 1);
            travel(nums, k, i + 1);
        } else {
            temp.remove(temp.size() - 1);
            travel(nums, k, i + 1);
        }

    }
}

