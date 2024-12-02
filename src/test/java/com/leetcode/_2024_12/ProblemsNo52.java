package com.leetcode._2024_12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 52. N 皇后 II
 *
 * @author DHW
 * @date 2024/12/2 10: 38
 * @Version 1.0
*/
public class ProblemsNo52 {

    @Test
    public void solution() {
        System.out.println("res = " + totalNQueens(4));
    }

    int res = 0;
    boolean[] c;
    boolean[] d;
    boolean[] e;

    public int totalNQueens(int n) {
        c = new boolean[n];
        d = new boolean[n << 1];
        e = new boolean[n << 1];
        dfs(0, n);
        return res;
    }

    private void dfs(int r, int n) {
        if(r == n) {
            res++;
            return;
        }
        for (int j = 0; j < n; j++) {
            int a = r + j; int b = n - r + j;
            if (c[j] || d[a] || e[b]) {
                continue;
            }
            c[j] = true;
            d[a] = true;
            e[b] = true;
            dfs(r + 1,  n);
            c[j] = false;
            d[a] = false;
            e[b] = false;
        }
    }
}

