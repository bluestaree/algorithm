package com.leetcode._2026_10;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 3371. 识别数组中的最大异常值
 *
 * @author DHW
 * @date 2026/10/13 10:45
 * @Version 1.0
*/
public class ProblemsNo3371 {

    @Test
    public void solution() {
        int[] nums = new int[]{2536,1613,3366,162};
        System.out.println("res = " + getLargestOutlier(nums));
    }

    public int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int total = 0;
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
            total += x;
        }

        int ans = Integer.MIN_VALUE;
        for (int x : nums) {
            cnt.merge(x, -1, Integer::sum);
            if ((total - x) % 2 == 0 && cnt.getOrDefault((total - x) / 2, 0) > 0) {
                ans = Math.max(ans, x);
            }
            cnt.merge(x, 1, Integer::sum);
        }
        return ans;
    }
}

