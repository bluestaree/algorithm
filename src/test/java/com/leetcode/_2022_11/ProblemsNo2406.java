package com.leetcode._2022_11;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 2406. 将区间分为最少组数
 *
 * @author DHW
 * @date 2022/11/21 14:50
 * @Version 1.0
*/
public class ProblemsNo2406 {

    @Test
    public void solution() {
        int[][] intervals = new int[][]{new int[]{935387,971021}, new int[]{866648,882725}, new int[]{617324,668847}, new int[]{207490,1229649}, new int[]{678354,738786}};
        System.out.println("s = " + minGroups1(intervals));
    }

    public int minGroups(int[][] intervals) {
        int[][] arround = new int[intervals.length][intervals.length * 2];
        int num = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            for (int j = 0; j < arround.length; j++) {
                if(arround[j][0] == 0 && arround[j][1] == 0) {
                    num++;
                    arround[j] = interval;
                    break;
                }

                boolean iscontain = false;
                for (int k = 1; k < arround[j].length; k += 2) {
                    if(interval[0] < arround[j][k]) {
                        arround[j][k] = interval[1];
                        iscontain = true;
                        break;
                    } else if(interval[1] < arround[j][k-1]) {
                        arround[j][k-1] = interval[0];
                        break;
                    }
                }

                if(iscontain) {
                    break;
                }

            }
        }
        return num;
    }

    public int minGroups1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!pq.isEmpty() && pq.peek() < interval[0]) pq.poll();
            pq.offer(interval[1]);
        }
        return pq.size();
    }
}
