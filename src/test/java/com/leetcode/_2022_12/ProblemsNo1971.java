package com.leetcode._2022_12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 1971. 寻找图中是否存在路径
 *
 * @author DHW
 * @date 2022/12/19 15:36
 * @Version 1.0
*/
public class ProblemsNo1971 {

    @Test
    public void solution() {
        int n = 1;
        int[][] edges = new int[][]{new int[]{1,2},new int[]{3,1},new int[]{2,4},new int[]{2,3},new int[]{4,4}};
        int source = 1;
        int destination = 1;
        System.out.println("res = " + validPath(n, edges, source, destination));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<List> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            list.get(x).add(y);
            list.get(y).add(x);
        }
        boolean[] check = new boolean[n];
        return dfs(source, destination, list, check);
    }

    private boolean dfs(int source, int destination, ArrayList<List> allList, boolean[] check) {
        if(source == destination) {
            return true;
        }
        List<Integer> list = allList.get(source);
        check[source] = true;
        for (int i = 0; i < list.size(); i++) {
            Integer x = list.get(i);
            if(!check[x] && dfs(x, destination, allList, check) ) {
                return true;
            }
        }
        return false;
    }
}
