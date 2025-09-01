package com.leetcode._2025_9;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 1792. 最大平均通过率
 *
 * @author DHW
 * @date 2025/9/1 11: 11
 * @Version 1.0
*/
public class ProblemsNo1792 {

    @Test
    public void solution() {
        int[][] classes =  new int[][]{new int[]{2,4},new int[]{3,9},new int[]{4,5},new int[]{2,10}};
        int extraStudents = 4;
        System.out.println("res = " + maxAverageRatio(classes, extraStudents));
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> {
            double x = (a[0] + 1) / (a[1] + 1) - (a[0] / a[1]);
            double y = (b[0] + 1) / (b[1] + 1) - (b[0] / b[1]);
            return Double.compare(y, x);
        });
        for (int[] class_ : classes) {
            queue.offer(new double[]{class_[0], class_[1]});
        }

        while (extraStudents > 0) {
            double[] poll = queue.poll();
            double a = poll[0] + 1, b = poll[1] + 1;
            queue.offer(new double[] {a, b});
            extraStudents--;
        }
        double ans = 0;
        while (!queue.isEmpty()) {
            double[] poll = queue.poll();
            ans += poll[0] / poll[1];
        }

        return ans / classes.length;
    }
}

