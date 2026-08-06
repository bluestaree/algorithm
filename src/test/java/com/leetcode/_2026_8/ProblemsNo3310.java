package com.leetcode._2026_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 3310. 移除可疑的方法
 *
 * @author DHW
 * @date 2026/8/05 9:50
 * @Version 1.0
*/
public class ProblemsNo3310 {

    @Test
    public void solution() {
        int n = 1;
        int k = 1;
        int[][] invocations = new int[][]{new int[]{3, 3}, new int[]{2, 2}, new int[]{1, 1}};
        System.out.println("res = " + remainingMethods(n, k, invocations));
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] invocation : invocations) {
            lists[invocation[0]].add(invocation[1]);
        }


        boolean[] targets = new boolean[n];
        dfs(k, targets, lists);

        List<Integer> ans = new ArrayList<>(n);
        for (int[] e : invocations) {
            if(!targets[e[0]] && targets[e[1]]) {
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!targets[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    private void dfs(int k, boolean[] targets, List<Integer>[] lists) {
        targets[k] = true;
        lists[k].forEach(i -> {
            if (!targets[i]) {
                dfs(i, targets, lists);
            }
        });
    }
}

