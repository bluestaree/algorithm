package com.leetcode._2025_4;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 3396. 使数组元素互不相同所需的最少操作次数
 *
 * @author DHW
 * @date 2025/4/8 8: 36
 * @Version 1.0
*/
public class ProblemsNo3396 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,3,12,0,4,6,7};
        System.out.println("res = " + minimumOperations(nums));
    }

    public int minimumOperations(int[] nums) {
        int res = 0;
        int time = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                res++;
                time += 3;
                i = time;
                set.clear();
            }
        }
        return res;
    }
}

