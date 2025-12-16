package com.leetcode._2025_12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


/**
 * 2841. 几乎唯一子数组的最大和
 *
 * @author DHW
 * @date 2025/12/3 8: 56
 * @Version 1.0
*/
public class ProblemsNo2841 {

    @Test
    public void solution() {
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(6);
        nums.add(7);
        nums.add(3);
        nums.add(1);
        nums.add(7);
        int k = 4;
        int m = 3;
        System.out.println("res = " + maxSum(nums, m, k));
    }

    public long maxSum(List<Integer> nums, int m, int k) {
        long ans = 0l;
        HashMap<Integer, Integer> map = new HashMap<>();
        long c = 0l;

        for (int i = 0; i < nums.size(); i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            c += nums.get(i);
            int l = i - k + 1;
            if(l < 0) {
                continue;
            }
            if(map.keySet().size() >= m) {
                ans = Math.max(ans, c);
            }
            c -= nums.get(l);
            if(map.containsKey(nums.get(l))) {
                Integer num = map.get(nums.get(l));
                if (num == 1) {
                    map.remove(nums.get(l));
                } else {
                    map.put(nums.get(l), num - 1);
                }
            }
        }
        return ans;
    }
}

