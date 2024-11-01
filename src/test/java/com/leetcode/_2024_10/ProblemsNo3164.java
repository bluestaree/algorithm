package com.leetcode._2024_10;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * 3164. 优质数对的总数 II
 *
 * @author DHW
 * @date 2024/10/11 8:53
 * @Version 1.0
*/
public class ProblemsNo3164 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{1,3,4};
        int[] nums2 = new int[]{1,3,4};
        int k = 1;
        System.out.println("res = " + numberOfPairs(nums1, nums2, k));
    }

    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            if(num % k == 0) {
                map1.merge(num / k, 1, Integer::sum);
            }
        }
        if(map1.isEmpty()) {
            return 0;
        }
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums2) {
            map2.merge(num, 1, Integer::sum);
        }
        long res = 0;
        int mx = map1.keySet().stream().max(Integer::compareTo).get();
        for (Map.Entry<Integer, Integer> e : map2.entrySet()) {
            int x = e.getKey(), v = e.getValue();
            int s = 0;
            for (int i = x; i <= mx; i+=x) {
                s += map1.getOrDefault(i, 0);
            }
            res += 1L * s * v;
        }
        return res;
    }
}

