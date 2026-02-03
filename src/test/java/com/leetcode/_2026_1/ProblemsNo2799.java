package com.leetcode._2026_1;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


/**
 * 2799. 统计完全子数组的数目
 *
 * @author DHW
 * @date 2026/1/30 9: 13
 * @Version 1.0
*/
public class ProblemsNo2799 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,3,1,2,2};
        System.out.println("res = " + countCompleteSubarrays(nums));
    }

    public int countCompleteSubarrays(int[] nums) {
        int ans = 0;
        int l = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int n = set.size();
        set.clear();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.size() == n) {
                Integer i = map.get(nums[l]);
                if (i == 1) {
                    map.remove(nums[l]);
                } else {
                    map.put(nums[l], i - 1);
                }
                l++;
            }
            ans += l;
        }
        return ans;
    }

}

