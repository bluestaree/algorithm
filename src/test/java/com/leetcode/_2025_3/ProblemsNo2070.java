package com.leetcode._2025_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2070. 每一个查询的最大美丽值
 *
 * @author DHW
 * @date 2025/3/9 11: 46
 * @Version 1.0
*/
public class ProblemsNo2070 {

    @Test
    public void solution() {
        int[][] items = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
        int[] queries = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("res = " + maximumBeauty(items, queries));
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int n = items.length;
        int m = queries.length;
        int[] ans = new int[m];
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; ++i) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> queries[i] - queries[j]);
        int i = 0, mx = 0;
        for (int j : idx) {
            while (i < n && items[i][0] <= queries[j]) {
                mx = Math.max(mx, items[i][1]);
                ++i;
            }
            ans[j] = mx;
        }
        return ans;
    }
}

