package com.leetcode._2025_4;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 2799. 统计完全子数组的数目
 *
 * @author DHW
 * @date 2025/4/24 8: 32
 * @Version 1.0
*/
public class ProblemsNo2799 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,3,1,2,2};
        System.out.println("res = " + countCompleteSubarrays(nums));
    }

    public int countCompleteSubarrays(int[] nums) {
        long sum = Arrays.stream(nums).distinct().count();
        int n = nums.length;
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int l = 0; l <= n - sum; l++) {
            set.clear();
            for (int r = l; r < n; r++) {
                set.add(nums[r]);
                if(set.size() == sum) {
                    res += n - r;
                    break;
                }
            }
        }
        return res;
    }
}

