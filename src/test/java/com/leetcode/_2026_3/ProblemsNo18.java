package com.leetcode._2026_3;

import org.junit.Test;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 18. 四数之和
 *
 * @author DHW
 * @date 2026/3/13 10: 36
 * @Version 1.0
*/
public class ProblemsNo18 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,2,3,3};
        int target = 5;
        System.out.println("res = " + fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            long x = nums[i];
            if (i > 0 && x == nums[i - 1]) {
                continue;
            }
            long s = x + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (s > target) {
                break;
            }
            s = x + nums[n - 1] + nums[n - 2] + nums[n - 3];
            if (s < target) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                long y = nums[j];
                if (j > i + 1 && y == nums[j - 1]) {
                    continue;
                }
                s = x + y + nums[j + 1] + nums[j + 2];
                if (s > target) {
                    break;
                }
                s = x + y + nums[n - 1] + nums[n - 2];
                if (s < target) {
                    continue;
                }
                int l = j + 1, r = n - 1;
                while (l < r) {
                    int z = nums[l], w = nums[r];
                    long sum = x + y + z + w;
                    if (sum == target) {
                        ans.add(Arrays.asList((int)x, (int)y, z, w));
                        while (l < r && nums[l] == z) {
                            l++;
                        }
                        while (l < r && nums[r] == w) {
                            r--;
                        }
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}

