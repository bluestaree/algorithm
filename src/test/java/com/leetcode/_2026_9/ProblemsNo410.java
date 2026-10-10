package com.leetcode._2026_9;

import org.junit.Test;


/**
 * 410. 分割数组的最大值
 *
 * @author DHW
 * @date 2026/9/7 9: 23
 * @Version 1.0
 */
public class ProblemsNo410 {

    @Test
    public void solution() {
        int[] nums = new int[]{7,2,5,10,8};
        System.out.println("= res = " + splitArray(nums, 2));
    }

    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int mx = 0;
        for (int num : nums) {
            r += num;
            mx = Math.max(mx, num);
        }
        l = mx;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(check(mid, nums, k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int mid, int[] nums, int k) {
        int s = 0;
        int cnt = 1;
        for (int num : nums) {
            if(s + num <= mid) {
                s += num;
                continue;
            }
            if(cnt == k) {
                return false;
            }
            cnt++;
            s = num;
        }
        return true;
    }
}

