package com.leetcode._2026_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 16. 最接近的三数之和
 *
 * @author DHW
 * @date 2026/3/12 15: 36
 * @Version 1.0
*/
public class ProblemsNo16 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,2,3,3};
        int target = 5;
        System.out.println("res = " + threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE / 2;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int s = x + nums[i + 1] + nums[i + 2];
            if(s > target) {
                if(s - target < Math.abs(ans - target)) {
                    ans = s;
                }
                break;
            }
            s = x + nums[n - 1] + nums[n - 2];
            if(s < target) {
                if(target - s < Math.abs(ans - target)) {
                    ans = s;
                }
                continue;
            }
            int l = i + 1, r = n - 1;
            while(l < r) {
                s = x + nums[l] + nums[r];
                if(s == target) {
                    return s;
                }
                if(s > target) {
                    if(s - target < Math.abs(ans - target)) {
                        ans = s;
                    }
                    r--;
                    while(l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else {
                    if(target - s < Math.abs(ans - target)) {
                        ans = s;
                    }
                    l++;
                    while(l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }
        return ans;
    }
}

