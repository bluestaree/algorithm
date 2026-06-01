package com.leetcode._2026_5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 228. 汇总区间
 *
 * @author DHW
 * @date 2026/5/20 10: 27
 * @Version 1.0
 */
public class ProblemsNo228 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,3,54,4,7};
        System.out.println("res = " + summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int l = 0, r = 0;
        while (r < nums.length) {
            if (r == nums.length - 1 || nums[r] != nums[r + 1] - 1) {
                if(l == r) {
                    ans.add(String.valueOf(nums[r]));
                } else {
                    ans.add(nums[l] + "->" + nums[r]);
                }
                l = r + 1;
            }
            r++;
        }
        return ans;
    }

}

