package com.leetcode._2023_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * 56. 合并区间
 *
 * @author DHW
 * @date 2023/8/27 11:16
 * @Version 1.0
*/
public class ProblemsNo56 {

    @Test
    public void solution() {
        int[][] intervals = new int[][]{new int[]{2,3}, new int[]{4,5}, new int[]{6,7}, new int[]{8,9}, new int[]{1,10}};
        System.out.println("res = " + merge(intervals));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
