package com.leetcode._2024_3;

import org.junit.Test;
import sun.font.FontRunIterator;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * 2368. 受限条件下可到达节点的数目
 *
 * @author DHW
 * @date 2024/3/2 11:21
 * @Version 1.0
*/
public class ProblemsNo2368 {

    @Test
    public void solution() {
        int n = 6;
        int[][] edges = new int[][]{new int[]{0,1}, new int[]{0,2}, new int[]{0,5}, new int[]{0,4}, new int[]{3,2}, new int[]{6,5}};
        int[] restricted = new int[]{4,2,1};
        System.out.println("res = " + reachableNodes(n, edges, restricted));
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashSet<Integer> set = new HashSet<>();
        boolean[] flag = new boolean[n];
        for (int i : restricted) {
            flag[i] = true;
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if(set.contains(x) || set.contains(y)) {
                continue;
            }
            list.get(x).add(y);
            list.get(y).add(x);
        }
        return dfs(list, 0, flag);
    }

    private int dfs(ArrayList<ArrayList<Integer>> list, int cur, boolean[] flag) {
        flag[cur] = true;
        int curCount = 1;
        for (Integer num : list.get(cur)) {
            if(flag[num]) {
                continue;
            }
            curCount += dfs(list, num, flag);
        }
        return curCount;
    }

}

