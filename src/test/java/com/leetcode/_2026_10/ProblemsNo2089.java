package com.leetcode._2026_10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 2089. 找出数组排序后的目标下标
 *
 * @author DHW
 * @date 2026/10/19 9:15
 * @Version 1.0
*/
public class ProblemsNo2089 {

    @Test
    public void solution() {
        int[] nums = new int[]{2536,1613,3366,162};
        int target = 2;
        System.out.println("res = " + targetIndices(nums, target));
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        int less = 0;
        int equal = 0;
        for (int num : nums) {
            if(num < target) {
                less++;
            }
            if(num == target) {
                equal++;
            }
        }
        List<Integer> ans = new ArrayList<>(equal);
        for (int i = 0; i < equal; i++) {
            ans.add(less + i);
        }

        return ans;
    }
}

