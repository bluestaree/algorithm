package com.leetcode._2023_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * 228. 汇总区间
 *
 * @author DHW
 * @date 2023/8/26 11:16
 * @Version 1.0
*/
public class ProblemsNo228 {

    @Test
    public void solution() {
        int[] nums = new int[]{0,1,2,4,5,7};
        System.out.println("res = " + summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for (int i = 0, j, n = nums.length; i < n; i = j + 1) {
            j = i;
            while (j + 1 < n && nums[j + 1] == nums[j] + 1) {
                ++j;
            }
            ans.add(f(nums, i, j));
        }
        return ans;
    }

    private String f(int[] nums, int i, int j) {
        return i == j ? nums[i] + "" : String.format("%d->%d", nums[i], nums[j]);
    }

    public List<String> summaryRanges1(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        if(nums.length == 0) {
            return list;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if(sb.length() == 0) {
                sb.append(nums[i-1]);
            }
            if(nums[i] != nums[i-1] + 1) {
                if(count >= 1) {
                    sb.append("->");
                    sb.append(nums[i-1]);
                }
                list.add(sb.toString());
                sb.delete(0, sb.length());
                count=0;
                continue;
            }
            count++;
        }
        if(count > 0) {
            sb.append("->");
        }
        sb.append(nums[nums.length-1]);
        list.add(sb.toString());
        return list;
    }

}
