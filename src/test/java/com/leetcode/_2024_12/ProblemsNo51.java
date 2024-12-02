package com.leetcode._2024_12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 51. N 皇后
 *
 * @author DHW
 * @date 2024/12/2 9: 08
 * @Version 1.0
*/
public class ProblemsNo51 {

    @Test
    public void solution() {
        System.out.println("res = " + solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] g = new char[n][n];
        for (char[] chars : g) {
            Arrays.fill(chars, '.');
        }
        dfs(0, 0, g, res, n);
        return res;
    }

    private void dfs(int r, int c, char[][] g, List<List<String>> res, int n) {
        if(r == n) {
            List<String> cur = new ArrayList<>();
            for (int i = 0; i < g.length; i++) {
                cur.add(new String(g[i]));
            }
            res.add(cur);
            return;
        }
        for (int j = c; j < n; j++) {
            if (check(r, j, g, n)) {
                g[r][j] = 'Q';
                dfs(r + 1, 0, g, res, n);
                g[r][j] = '.';
            }
        }
    }

    private static boolean check(int r, int c, char[][] g, int n) {
        for (int i = r - 1, j = c + 1, k = c - 1; i >= 0; i--, j++, k--) {
            if (g[i][c] == 'Q' || (j < n && g[i][j] == 'Q') || (k >= 0 && g[i][k] == 'Q')) {
                return false;
            }
        }
        return true;
    }
}

