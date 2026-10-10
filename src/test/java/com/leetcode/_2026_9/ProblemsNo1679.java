package com.leetcode._2026_9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 1679. K 和数对的最大数目
 *
 * @author DHW
 * @date 2026/9/29 9:08
 * @Version 1.0
*/
public class ProblemsNo1679 {

    @Test
    public void solution() {
        int[] nums = new int[]{93,93};
        int k = 1;
        System.out.println("res = " + maxOperations(nums, k));
    }

    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            Integer c = cnt.getOrDefault(k - num, 0);
            if(c > 0) {
                ans++;
                cnt.put(k - num, c - 1);
            } else {
                cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            }
        }
        return ans;
    }

    public  List<List<Integer>> maxOperations1(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            int x = target - num;
            Integer c = cnt.getOrDefault(x, 0);
            if(c > 0) {
                List<Integer> pair = new ArrayList<>();
                pair.add(num);
                pair.add(x);
                ans.add(pair);
                cnt.put(x, c - 1);
            } else {
                cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            }
        }
        return ans;
    }
}

