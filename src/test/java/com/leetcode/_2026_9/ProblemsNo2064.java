package com.leetcode._2026_9;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2064. 分配给商店的最多商品的最小值
 *
 * @author DHW
 * @date 2026/9/11 8: 55
 * @Version 1.0
 */
public class ProblemsNo2064 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,2,3,1};
        System.out.println("= res = " + minimizedMaximum(2, nums));
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = 0;
        for (int i = 0; i < quantities.length; i++) {
            r = Math.max(r, quantities[i]);
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(check(mid, n, quantities)) {
                r = mid - 1;
            } else{
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int mid, int n, int[] nums) {
        int cnt = 0;
        for (int q : nums) {
            cnt += (q + mid - 1) / mid;
        }
        return cnt <= n;
    }
}

