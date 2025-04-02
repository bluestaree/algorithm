package com.leetcode._2025_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 2140. 解决智力问题
 *
 * @author DHW
 * @date 2025/4/1 8: 52
 * @Version 1.0
*/
public class ProblemsNo2140 {

    @Test
    public void solution() {
        int[][] questions = new int[][]{new int[]{1,2,3},new int[]{5,6,7},new int[]{9,10,11}};
        System.out.println("res = " + mostPoints(questions));
    }


    int n;
    private Long[] f;
    int[][] questions;

    public long mostPoints(int[][] questions) {
        n = questions.length;
        f = new Long[n];
        this.questions = questions;
        return dfs(0);
    }

    private long dfs(int i) {
        if(i >= n) {
            return 0;
        }
        if(f[i] != null) {
            return f[i];
        }
        int a = questions[i][0];
        int b = questions[i][1];
        f[i] = Math.max(a + dfs(i + b +1), dfs(i+1));
        return f[i];
    }
}

