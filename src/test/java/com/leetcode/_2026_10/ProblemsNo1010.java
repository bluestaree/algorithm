package com.leetcode._2026_10;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 1010. 总持续时间可被 60 整除的歌曲
 *
 * @author DHW
 * @date 2026/10/16 10:21
 * @Version 1.0
*/
public class ProblemsNo1010 {

    @Test
    public void solution() {
        int[] nums = new int[]{60,60,60,60,60};
        System.out.println("res = " + numPairsDivisibleBy60(nums));
    }

    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : time) {
            int y = x % 60;
            Integer num = map.getOrDefault((60 - y) % 60, 0);
            ans += num;
            map.put(y, map.getOrDefault(y, 0) + 1);
        }
        return ans;
    }
}

