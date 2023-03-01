package com.leetcode._2023_2;

import org.junit.Test;

import java.util.*;


/**
 * 2363. 合并相似的物品
 *
 * @author DHW
 * @date 2023/2/28 9:26
 * @Version 1.0
*/
public class ProblemsNo2363 {

    @Test
    public void solution() {
        int[][] items1 = new int[][]{new int[]{1,2}, new int[]{2,3}};
        int[][] items2 = new int[][]{new int[]{1,2}, new int[]{2,3}};
        System.out.println("res = " + mergeSimilarItems(items1, items2));
    }

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < items1.length; i++) {
            map.put(items1[i][0], map.getOrDefault(items1[i][0] , 0) + items1[i][1]);
        }
        for (int i = 0; i < items2.length; i++) {
            map.put(items2[i][0], map.getOrDefault(items2[i][0] , 0) + items2[i][1]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> list = new ArrayList<>();
            list.add(entry.getKey());
            list.add(entry.getValue());
            res.add(list);
        }
        return res;
    }
}
