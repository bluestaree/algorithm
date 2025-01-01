package com.leetcode._2024_12;

import org.junit.Test;

import java.util.*;


/**
 * 2545. 根据第 K 场考试的分数排序
 *
 * @author DHW
 * @date 2024/12/21 11: 14
 * @Version 1.0
*/
public class ProblemsNo2545 {

    @Test
    public void solution() {
        int k = 1;
        int[][] score = new int[][]{new int[]{2,4}, new int[]{0,2}, new int[]{0,4}};
        System.out.println("res = " + sortTheStudents(score, k));
    }


    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> (b[k] - a[k]));
        return score;
    }

}

