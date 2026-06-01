package com.leetcode._2026_5;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1665. 完成所有任务的最少初始能量
 *
 * @author DHW
 * @date 2026/5/12 8:46
 * @Version 1.0
*/
public class ProblemsNo1665 {

    @Test
    public void solution() {
        int[][] tasks = new int[][]{new int[]{1,2}, new int[]{2,3}};
        System.out.println("res = " + minimumEffort(tasks));
    }

    public int minimumEffort(int[][] tasks) {
        int ans = 0;
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int s = 0;

        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];
            ans = Math.max(ans, s + minimum);
            s += actual;
        }
        return ans;
    }
}
