package com.leetcode._2025_11;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 2154. 将找到的值乘以 2
 *
 * @author DHW
 * @date 2025/11/19 8: 43
 * @Version 1.0
*/
public class ProblemsNo2154 {

    @Test
    public void solution() {
        int[] nums =  new int[]{5,3,6,1,12};
        int original = 2;
        System.out.println("res = " + findFinalValue(nums, original));
    }

    public int findFinalValue(int[] nums, int original) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        while (s.contains(original)) {
            original <<= 1;
        }
        return original;
    }

}

