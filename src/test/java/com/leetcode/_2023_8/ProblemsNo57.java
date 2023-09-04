package com.leetcode._2023_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 57. 插入区间
 *
 * @author DHW
 * @date 2023/8/28 9:36
 * @Version 1.0
*/
public class ProblemsNo57 {

    @Test
    public void solution() {
        int[][] intervals = new int[][]{new int[]{1,3}, new int[]{6,9}};
        int[] newInterval = new int[]{2,5};
        System.out.println("res = " + insert1(intervals, newInterval));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            newIntervals[i] = intervals[i];
        }
        newIntervals[intervals.length] = newInterval;
        Arrays.sort(newIntervals, (x,y) -> x[0] - y[0]);

        ArrayList<int[]> list = new ArrayList<>();
        list.add(newIntervals[0]);
        for (int i = 1; i < newIntervals.length; i++) {
            int left = newIntervals[i][0];
            int right = newIntervals[i][1];
            if(list.get(list.size()-1)[1] < left) {
                list.add(new int[]{left, right});
            } else {
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], right);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];

        boolean mark = false;
        for (int i = 0; i < intervals.length;i++) {
            if(intervals[i][0] > right) {
                if(!mark) {
                    list.add(new int[]{left, right});
                    mark=true;
                }
                list.add(intervals[i]);
            } else if(intervals[i][1] < left) {
                list.add(intervals[i]);
            } else {
                left = Math.min(intervals[i][0], left);
                right = Math.max(intervals[i][1], right);
            }
        }
        if(!mark) {
            list.add(new int[]{left, right});
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

}
