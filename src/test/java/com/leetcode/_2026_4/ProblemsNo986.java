package com.leetcode._2026_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 986. 区间列表的交集
 *
 * @author DHW
 * @date 2023/1/14 9:39
 * @Version 1.0
 */
public class ProblemsNo986 {

    @Test
    public void solution() {
        int[][] firstList = new int[][]{new int[]{0,2}, new int[]{5,10}, new int[]{13,23}, new int[]{24,25}};
        int[][] secondList = new int[][]{new int[]{1,5}, new int[]{8,12}, new int[]{15,24}, new int[]{25,26}};
        System.out.println("res = " + intervalIntersection(firstList, secondList));
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intervals = new ArrayList<int[]>();
        for (int i = 0,j = 0; i < firstList.length && j < secondList.length;) {
            if(firstList[i][0] <= secondList[j][1] || firstList[i][1] >= secondList[j][0]) {
                int[] interval = new int[2];
                interval[0] = Math.max(firstList[i][0], secondList[j][0]);
                interval[1] = Math.min(firstList[i][1], secondList[j][1]);
                if(interval[0] <= interval[1]) {
                    intervals.add(interval);
                }
            }
            if(firstList[i][1] == secondList[j][1]) {
                i++;
                j++;
            } else if(firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] ans = new int[intervals.size()][2];
        for (int i = 0; i < intervals.size(); i++) {
            ans[i] = intervals.get(i);
        }
        return ans;
    }
}
