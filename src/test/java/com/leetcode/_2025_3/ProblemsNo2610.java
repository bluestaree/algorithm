package com.leetcode._2025_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 2610. 转换二维数组
 *
 * @author DHW
 * @date 2025/3/11 8: 46
 * @Version 1.0
*/
public class ProblemsNo2610 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,6};
        System.out.println("res = " + findMatrix(nums));
    }



    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean tag = false;
            for (List<Integer> list : a) {
                if(!list.contains(nums[i])) {
                    list.add(nums[i]);
                    tag = true;
                    break;
                }
            }
            if(!tag) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                a.add(list);
            }
        }
        return a;
    }
}

