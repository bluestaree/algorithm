package com.leetcode._2024_11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 3243. 新增道路查询后的最短距离 I
 *
 * @author DHW
 * @date 2024/11/19 9: 45
 * @Version 1.0
*/
public class ProblemsNo3243 {

    @Test
    public void solution() {
        int n = 5;
        int[][] queries = new int[][]{new int[]{2,4}, new int[]{0,2}, new int[]{0,4}};
        System.out.println("res = " + shortestDistanceAfterQueries(n, queries));
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] arrays = new List[n];
        for (int i = 0; i < n; i++) {
            ArrayList list = new ArrayList();
            if(i + 1 < n) {
                list.add(i+1); 
            }
            arrays[i] = list;
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] vis = new int[n];
            vis[0] = 1;
            arrays[queries[i][0]].add(queries[i][1]);
            res[i] = bfs(new HashSet<>(arrays[0]), n-1, arrays, 1, vis);
        }
        return res;
    }

    private int bfs(Set<Integer> curs, int target, List<Integer>[] arrays, int n, int[] vis) {
        Set<Integer> ns = new HashSet<>();
        for (Integer next : curs) {
            if(next == target) {
                return n;
            }
            if(vis[next] == 1) {
                continue;
            }
            vis[next] = 1;
            ns.addAll(arrays[next]);
        }
        return bfs(ns, target, arrays, n+1, vis);
    }

}

