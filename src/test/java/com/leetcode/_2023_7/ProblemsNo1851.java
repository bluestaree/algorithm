package com.leetcode._2023_7;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 1851. 包含每个查询的最小区间
 *
 * @author DHW
 * @date 2023/7/18 9:33
 * @Version 1.0
*/
public class ProblemsNo1851 {

    @Test
    public void solution() {
        int[] queries = new int[]{2,3,4,5};
        int[][] intervals = new int[][]{new int[]{1,4}, new int[]{2,4}, new int[]{3,6}, new int[]{4,4}};
        System.out.println("res = " + minInterval(intervals, queries));
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        int a = intervals.length;
        int b = queries.length;
        int[] res = new int[b];
        Arrays.fill(res, -1);

        Arrays.sort(intervals, (x,y) -> x[0] - y[0]);


        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((x, y) -> x - y);

        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < a; j++) {
                if(intervals[j][0] > queries[i]) {
                    break;
                }
                if(intervals[j][0] <= queries[i] && intervals[j][1] >= queries[i]) {
                    queue.offer(intervals[j][1] - intervals[j][0] + 1);
                }
            }

            if (!queue.isEmpty()) {
                res[i] = queue.peek();
                queue.clear();
            }
        }

        return res;
    }

    public int[] minInterval1(int[][] intervals, int[] queries) {
        int n = intervals.length, m = queries.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] qs = new int[m][0];
        for (int i = 0; i < m; ++i) {
            qs[i] = new int[] {queries[i], i};
        }
        Arrays.sort(qs, (a, b) -> a[0] - b[0]);
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0;
        for (int[] q : qs) {
            while (i < n && intervals[i][0] <= q[0]) {
                int a = intervals[i][0], b = intervals[i][1];
                pq.offer(new int[] {b - a + 1, b});
                ++i;
            }
            while (!pq.isEmpty() && pq.peek()[1] < q[0]) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                ans[q[1]] = pq.peek()[0];
            }
        }
        return ans;
    }
}
