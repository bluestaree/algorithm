package com.leetcode._2025_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 2176. 统计数组中相等且可以被整除的数对
 *
 * @author DHW
 * @date 2025/4/17 8: 37
 * @Version 1.0
*/
public class ProblemsNo2176 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,1,1,1,1};
        int k = 2;
        System.out.println("res = " + countPairs(nums, k));
    }

    public int countPairs(int[] nums, int k) {
        List<Integer>[] lists = new List[101];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(lists[nums[i]] != null) {
                for (Integer x : lists[nums[i]]) {
                    if(i * x % k == 0) {
                        res++;
                    }
                }
            } else {
                lists[nums[i]] = new ArrayList();
            }
            lists[nums[i]].add(i);
        }
        return res;
    }
}

