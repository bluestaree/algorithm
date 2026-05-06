package com.leetcode._2026_4;

import cn.hutool.core.comparator.ReverseComparator;
import org.junit.Test;

import java.util.*;


/**
 * 3761. 镜像对之间最小绝对距离
 *
 * @author DHW
 * @date 2026/4/10 8: 35
 * @Version 1.0
 */
public class ProblemsNo3761 {

    @Test
    public void solution() {
        int[] nums = new int[]{74,47,57};
        System.out.println("sortArrayByParity(nums) = " + minMirrorPairDistance(nums));
    }

    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int ans = n;
        Map<Integer, Integer> lastIndex = new HashMap<>(n, 1);

        for (int j = 0; j < n; j++) {
            int x = nums[j];
            Integer i = lastIndex.get(x);
            if (i != null) {
                ans = Math.min(ans, j - i);
            }

            int rev = 0;
            for (; x > 0; x /= 10) {
                rev = rev * 10 + x % 10;
            }
            lastIndex.put(rev, j);
        }
        return ans < n ? ans : -1;
    }
}

