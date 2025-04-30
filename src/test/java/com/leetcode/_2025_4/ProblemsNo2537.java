package com.leetcode._2025_4;

import org.junit.Test;

import java.util.HashMap;


/**
 * 2537. 统计好子数组的数目
 *
 * @author DHW
 * @date 2025/4/16 9: 07
 * @Version 1.0
*/
public class ProblemsNo2537 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,1,1,1,1};
        int k = 10;
        System.out.println("res = " + countGood(nums, k));
    }

    public long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int res = 0;
        int count = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            Integer num = map.merge(nums[i], 1, Integer::sum);
            if(num >= 2) {
                count += num - 1;
                while(count >= k) {
                    res += n - i;
                    Integer l = map.getOrDefault(nums[left], 0);
                    if(l >= 2) {
                        count -= l - 1;
                    }
                    map.put(nums[left], Math.max(0, l - 1));
                    left++;
                }
            }
        }
        return res;
    }
}

