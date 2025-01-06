package com.leetcode._2024_12;

import org.junit.Test;

import java.util.*;


/**
 * 3159. 查询数组中元素的出现位置
 *
 * @author DHW
 * @date 2024/12/27 9: 06
 * @Version 1.0
*/
public class ProblemsNo3159 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,3,1,7};
        int[] queries = new int[]{1,3,2,4};
        int x = 5;
        System.out.println("res = " + occurrencesOfElement(nums, queries, x));
    }

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == x) {
                ids.add(i);
            }
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            int j = queries[i] - 1;
            ans[i] = j < ids.size() ? ids.get(j) : -1;
        }
        return ans;
    }
}

