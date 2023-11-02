package com.leetcode._2023_10;

import org.junit.Test;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;


/**
 * 2530. 执行 K 次操作后的最大分数
 *
 * @author DHW
 * @date 2023/10/18 9:17
 * @Version 1.0
*/
public class ProblemsNo2530 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,10,3,3,3};
        int k = 3;
        System.out.println("res = " + maxKelements(nums, k));
    }

    public long maxKelements(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            Integer key = map.lastKey();
            Integer num = map.get(key);
            res += key;
            if(num > 1) {
                map.put(key, num--);
            } else {
                map.remove(key);
            }
            key = (int) Math.ceil(key / 3.0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return res;
    }

    public long maxKelements1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int v : nums) {
            pq.offer(v);
        }
        long ans = 0;
        while (k-- > 0) {
            int v = pq.poll();
            ans += v;
            pq.offer((v + 2) / 3);
        }
        return ans;
    }
}

