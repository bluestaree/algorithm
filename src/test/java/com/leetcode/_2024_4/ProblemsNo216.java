package com.leetcode._2024_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 216. 组合总和 III
 *
 * @author DHW
 * @date 2024/4/21 10:16
 * @Version 1.0
*/
public class ProblemsNo216 {

    @Test
    public void solution() {
        int k = 3;
        int n = 7;
        System.out.println("res = " + combinationSum3(k, n));
    }

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(0, n, k);
        return ans;
    }

    private void dfs(int i, int s, int k) {
        if(s == 0 && k == 0) {
            ans.add(new ArrayList<>(t));
            return;
        }
        if(s < i || k < 0) {
            return;
        }
        for (int j = i + 1; j <= 9; j++) {
            t.add(j);
            dfs(j, s - j, k - 1);
            t.remove(t.size() - 1);
        }
    }
}

