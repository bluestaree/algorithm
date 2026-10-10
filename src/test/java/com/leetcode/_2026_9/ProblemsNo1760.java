package com.leetcode._2026_9;

import org.junit.Test;


/**
 * 1760. 袋子里最少数目的球
 *
 * @author DHW
 * @date 2026/9/14 10:12
 * @Version 1.0
*/
public class ProblemsNo1760 {

    @Test
    public void solution() {
        int[] nums = new int[]{5,0,1,4};
        int k = 10;
        System.out.println("res = " + minimumSize(nums, k));
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int r = 0;
        for (int num : nums) {
            r = Math.max(r, num);
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(check(mid, nums, maxOperations)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int mid, int[] nums, int maxOperations) {
        long cnt = 0;
        for (int x : nums) {
            cnt += (x - 1) / mid;
        }
        return cnt <= maxOperations;
    }
}

