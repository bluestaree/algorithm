package com.leetcode._2024_10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 3211. 生成不含相邻零的二进制字符串
 *
 * @author DHW
 * @date 2024/10/29 8:38
 * @Version 1.0
*/
public class ProblemsNo3211 {

    @Test
    public void solution() {
        int n = 2;
        System.out.println("res = " + validStrings(n));
    }

    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        char[] path = new char[n];
        dfs(0, n, path, res);
        return res;
    }

    private void dfs(int i, int n, char[] path, List<String> res) {
        if(i == n) {
            res.add(new String(path));
            return;
        }

        path[i] = '1';
        dfs(i+1, n, path, res);

        if(i == 0 || path[i-1] == '1') {
            path[i] = '0';
            dfs(i+1, n, path, res);
        }
    }
}

