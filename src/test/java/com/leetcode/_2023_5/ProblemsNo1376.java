package com.leetcode._2023_5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 1376. 通知所有员工所需的时间
 *
 * @author DHW
 * @date 2023/5/1 11:26
 * @Version 1.0
*/
public class ProblemsNo1376 {

    @Test
    public void solution() {
        int[] manager = new int[]{1, 2, 3};
        int[] informTime = new int[]{1, 2, 3};
        int n = 2;
        int headID = 3;
        System.out.println("res = " + numOfMinutes(n, headID, manager, informTime));
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < manager.length; i++) {
            List<Integer> list = map.getOrDefault(manager[i], new ArrayList<>());
            list.add(i);
            map.put(manager[i], list);
        }

        return dfs(headID, informTime, map);
    }

    private int dfs(int cur, int[] informTime, HashMap<Integer, List<Integer>> map) {
        int res = 0;
        List<Integer> list = map.getOrDefault(cur, new ArrayList<>());
        for (int i = 0; i < list.size(); i++) {
            res = Math.max(res, dfs(list.get(i), informTime, map));
        }
        return informTime[cur] + res;
    }
}
