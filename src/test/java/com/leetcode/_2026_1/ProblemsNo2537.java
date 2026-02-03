package com.leetcode._2026_1;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;


/**
 * 2537. 统计好子数组的数目
 *
 * @author DHW
 * @date 2026/1/30 9: 13
 * @Version 1.0
*/
public class ProblemsNo2537 {

    @Test
    public void solution() {
        int[] nums = new int[]{3,1,4,3,2,2,4};
        int k = 2;
        System.out.println("res = " + countGood(nums, k));
    }
    public long countGood(int[] nums, int k) {
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int countPairs = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer num = map.getOrDefault(nums[i], 0);
            countPairs += num;
            map.put(nums[i], num + 1);
            while (countPairs >= k) {
                int leftNum = nums[l];
                int leftCount = map.get(leftNum);
                countPairs -= leftCount - 1;
                map.put(leftNum, leftCount - 1);
                l++;
            }
            ans += l;
        }
        return ans;
    }

}

