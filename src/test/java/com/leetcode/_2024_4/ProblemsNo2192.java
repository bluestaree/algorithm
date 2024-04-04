package com.leetcode._2024_4;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * 2192. 有向无环图中一个节点的所有祖先
 *
 * @author DHW
 * @date 2024/4/4 11:47
 * @Version 1.0
*/
public class ProblemsNo2192 {

    @Test
    public void solution() {
        int n = 8;
        int[][] edges = new int[][]{new int[]{0,3}, new int[]{0,4}, new int[]{1,3}, new int[]{2,4}, new int[]{2,7}, new int[]{3,5}, new int[]{3,6}, new int[]{3,7}, new int[]{4,6}};
        System.out.println("res = " + getAncestors(n, edges));
    }

    int n;
    List<Integer>[] g;
    List<List<Integer>> res;
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        this.n = n;
        g = new List[n];
        res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList();
            res.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
        }
        for (int i = 0; i < n; ++i) {
            bfs(i);
        }
        return res;
    }

    private void bfs(int i) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offer(i);
        boolean[] v = new boolean[n];
        v[i] = true;
        while (!deque.isEmpty()) {
            Integer pre = deque.poll();
            for (Integer next : g[pre]) {
                if(!v[next]) {
                    v[next] = true;
                    deque.offer(next);
                    res.get(next).add(i);
                }
            }
        }
    }


}

