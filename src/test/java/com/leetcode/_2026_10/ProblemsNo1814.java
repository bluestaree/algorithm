package com.leetcode._2026_10;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * 1814. 统计一个数组中好对子的数目
 *
 * @author DHW
 * @date 2026/10/15 10:19
 * @Version 1.0
*/
public class ProblemsNo1814 {

    @Test
    public void solution() {
        int[] nums = new int[]{42,11,1,97};
        System.out.println("res = " + countNicePairs(nums));
    }

    public int countNicePairs(int[] nums) {
        int ans = 0;
        int mod = (int) 1e9 + 7;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int rev = 0;
            for (int x = num; x > 0; x /= 10) {
                rev = rev * 10 + x % 10;
            }
            int key = num - rev;
            Integer y = map.getOrDefault(key, 0);
            ans += y % mod;
            map.put(key, y + 1);
        }
        return ans;
    }
}

