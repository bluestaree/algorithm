package com.leetcode._2025_11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 2872. 可以被 K 整除连通块的最大数目
 *
 * @author DHW
 * @date 2025/11/28 15:36
 * @Version 1.0
*/
public class ProblemsNo2872 {

    @Test
    public void solution() {
        int n = 1;
        int[][] edges = new int[][]{new int[]{1,2},new int[]{3,1},new int[]{2,4},new int[]{2,3},new int[]{4,4}};
        int[] values =  new int[]{1,2,3,4,1};
        int k = 1;
        System.out.println("res = " + maxKDivisibleComponents(n, edges, values, k));
    }

    int ans = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList();
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            lists[a].add(b);
            lists[b].add(a);
        }

        dfs(0, -1, lists, values, k);
        return ans;
    }

    private long  dfs(int i, int j, List<Integer>[] lists, int[] values, int k) {
        long sum = values[i];
        for (int x : lists[i]) {
            if(x != j) {
                sum += dfs(x, i, lists, values, k);
            }
        }
        ans += sum % k == 0 ? 1 : 0;
        return sum;
    }
}
