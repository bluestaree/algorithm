package com.leetcode._2026_8;

import org.junit.Test;


/**
 * 3824. 减小数组使其满足条件的最小 K 值
 *
 * @author DHW
 * @date 2026/8/21 8: 41
 * @Version 1.0
 */
public class ProblemsNo3824 {

    @Test
    public void solution() {
        int[] nums = new int[]{100000};
        System.out.println("= res = " + minimumK(nums));
    }

    public int minimumK(int[] nums) {
        int l = 1;
        int r = 0;
        for (int num : nums) {
            r = Math.max(r, num);
        }
        r = Math.max(r, nums.length - 1);
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(check(mid, nums)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int mid, int[] nums) {
        long t = 0;
        for (int num : nums) {
            t += (num - 1) / mid + 1;
        }
        return t <= (long) mid * mid;
    }
}

