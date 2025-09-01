package com.leetcode._2025_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 498. 对角线遍历
 *
 * @author DHW
 * @date 2025/8/25 9: 17
 * @Version 1.0
*/
public class ProblemsNo498 {

    @Test
    public void solution() {
        int[][] mat =  new int[][]{new int[]{1,2,3,4,5,6,7,8,9,10}};
        System.out.println("res = " + findDiagonalOrder(mat));
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int idx = 0;
        List<Integer> t = new ArrayList<>();
        for (int k = 0; k < m + n - 1; ++k) {
            int i = k < n ? 0 : k - n + 1;
            int j = k < n ? k : n - 1;
            while (i < m && j >= 0) {
                t.add(mat[i][j]);
                ++i;
                --j;
            }
            if (k % 2 == 0) {
                Collections.reverse(t);
            }
            for (int v : t) {
                ans[idx++] = v;
            }
            t.clear();
        }
        return ans;

    }
}

