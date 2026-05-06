package com.leetcode._2026_4;

import org.junit.Test;

import java.util.*;


/**
 * 3740. 三个相等元素之间的最小距离 I
 *
 * @author DHW
 * @date 2026/4/10 8: 35
 * @Version 1.0
 */
public class ProblemsNo3740 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println("sortArrayByParity(nums) = " + minimumDistance(nums));
    }

    public int minimumDistance(int[] nums) {
        int ans = Integer.MAX_VALUE;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        for (List<Integer> list : map.values()) {
            if(list.size() >= 3) {
                for (int i = 0; i < list.size() - 2; i++) {
                    int distance = (list.get(i + 2) - list.get(i)) * 2;
                    ans = Math.min(ans, distance);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

