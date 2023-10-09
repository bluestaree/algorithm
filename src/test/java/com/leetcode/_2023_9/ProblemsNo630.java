package com.leetcode._2023_9;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 630. 课程表 III
 *
 * @author DHW
 * @date 2023/9/11 14:08
 * @Version 1.0
*/
public class ProblemsNo630 {

    @Test
    public void solution() {
        int[][] courses = new int[][]{new int[]{3,5}, new int[]{2,7}};
        System.out.println("res = " + scheduleCourse(courses));
    }

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int s = 0;
        for (int[] e : courses) {
            int duration = e[0], last = e[1];
            pq.offer(duration);
            s += duration;
            while (s > last) {
                s -= pq.poll();
            }
        }
        return pq.size();
    }
}
