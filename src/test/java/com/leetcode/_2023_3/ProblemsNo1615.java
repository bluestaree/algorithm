package com.leetcode._2023_3;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * 1615. 最大网络秩
 *
 * @author DHW
 * @date 2023/3/15 16:27
 * @Version 1.0
*/
public class ProblemsNo1615 {

    @Test
    public void solution() {
        int n = 2;
        int[][] roads = new int[][]{new int[]{1,0}};
        System.out.println("res = " + maximalNetworkRank(n, roads));
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] count = new int[n];
        List<int[]> collect = Arrays.stream(roads).sorted((x, y) -> x[0] - y[0]).collect(Collectors.toList());

        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < collect.size(); i++) {
            int[] ints = collect.get(i);
            int start = ints[0];
            int end = ints[1];
            Set<Integer> startset = map.getOrDefault(start, new HashSet<>());
            startset.add(end);
            Set<Integer> endset = map.getOrDefault(end, new HashSet<>());
            endset.add(start);
            map.put(start, startset);
            map.put(end, endset);
            count[start] += 1;
            count[end] += 1;
        }
        for (int i = 0; i < count.length; i++) {
            for (int j = i + 1; j < count.length; j++) {
                Set<Integer> set = map.get(i);
                if(set != null && set.contains(j)) {
                    res = Math.max(res, count[i] + count[j] - 1);
                } else {
                    res = Math.max(res, count[i] + count[j]);
                }
            }
        }
        return res;
    }
}
