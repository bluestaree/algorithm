package com.leetcode._2026_8;

import org.junit.Test;


/**
 * 275. H 指数 II
 *
 * @author DHW
 * @date 2026/8/24 8: 44
 * @Version 1.0
 */
public class ProblemsNo275 {

    @Test
    public void solution() {
        int[] nums = new int[]{0,1,3,5,6};
        System.out.println("= res = " + hIndex(nums));
    }

    public int hIndex(int[] citations) {
        int l = 1;
        int n = citations.length;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(citations[n-mid] >= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }

}

