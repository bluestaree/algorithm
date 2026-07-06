package com.leetcode._2026_7;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;


/**
 * 1288. 删除被覆盖区间
 *
 * @author DHW
 * @date 2026/7/6 9: 11
 * @Version 1.0
 */
public class ProblemsNo1288 {

    @Test
    public void solution() {
        int[][] intervals = new int[][]{new int[]{1,4}, new int[]{3,6}, new int[]{2,8}};
        System.out.println("= res = " + removeCoveredIntervals(intervals));
    }

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        int ans = 0;
        int maxR = 0;

        for (int[] interval : intervals) {
            if(interval[1] > maxR) {
                maxR = interval[1];
                ans++;
            }
        }
        return ans;
    }
}

