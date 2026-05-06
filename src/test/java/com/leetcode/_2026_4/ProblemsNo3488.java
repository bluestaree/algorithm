package com.leetcode._2026_4;

import org.junit.Test;

import java.util.*;


/**
 * 3488. 距离最小相等元素查询
 *
 * @author DHW
 * @date 2026/4/10 8: 35
 * @Version 1.0
 */
public class ProblemsNo3488 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,3,1,4,1,3,2};
        int[] queries = new int[]{0,3,5};
        System.out.println("sortArrayByParity(nums) = " + solveQueries(nums, queries));
    }


    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        map.forEach((k, v) -> {
            List<Integer> list = map.get(k);
            int num = list.get(0);
            list.add(0, list.get(list.size() - 1) - n);
            list.add(num + n);
        });
        int m = queries.length;
        List<Integer> ans = new ArrayList<>(m);

        for (int i = 0; i < m; i++) {
            int q = queries[i];
            List<Integer> list = map.get(nums[q]);
            if(list.size() == 3) {
                ans.add(-1);
            } else {
                int index = Collections.binarySearch(list, q);
                ans.add(Math.min(q - list.get(index - 1), list.get(index + 1) - q));
            }
        }
        return ans;
    }
}

