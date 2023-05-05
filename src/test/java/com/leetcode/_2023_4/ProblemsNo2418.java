package com.leetcode._2023_4;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;


/**
 * 2418. 按身高排序
 *
 * @author DHW
 * @date 2023/4/25 11:21
 * @Version 1.0
*/
public class ProblemsNo2418 {

    @Test
    public void solution() {
        String[] names = new String[]{"Mary","John","Emma"};
        int[] heights = new int[]{180,165,170};
        System.out.println("res = " + sortPeople(names, heights));
    }

    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> treeMap = new TreeMap<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < heights.length; i++) {
            treeMap.put(heights[i], names[i]);
        }
        return treeMap.values().toArray(new String[names.length]);
    }
}
