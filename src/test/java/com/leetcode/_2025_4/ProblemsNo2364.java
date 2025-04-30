package com.leetcode._2025_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 2364. 统计坏数对的数目
 *
 * @author DHW
 * @date 2025/4/18 11: 38
 * @Version 1.0
*/
public class ProblemsNo2364 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,2,2};
        System.out.println("res = " + countBadPairs(nums));
    }

    public long countBadPairs(int[] nums) {
        long res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i] - i;
            Integer x = map.getOrDefault(num, 0);
            if(x > 0) {
                res += i - x;
            } else {
                res += i;
            }
            map.merge(num, 1, Integer::sum);
        }
        return res;
    }
}

