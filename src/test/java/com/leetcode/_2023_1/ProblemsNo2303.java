package com.leetcode._2023_1;

import org.junit.Test;


/**
 * 2303. 计算应缴税款总额
 *
 * @author DHW
 * @date 2023/1/23 17:46
 * @Version 1.0
*/
public class ProblemsNo2303 {

    @Test
    public void solution() {
        int[][] brackets = new int[][]{new int[]{2,7}, new int[]{3,17}, new int[]{4,37},
                new int[]{7,6}, new int[]{9,83}, new int[]{16,67}, new int[]{19,29}};
        int income = 18;
        System.out.println("res = " + calculateTax(brackets, income));
    }

    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        double upperPre = brackets[0][0];
        double percent1 = brackets[0][1];
        if(income <= upperPre) {
            return income * (percent1 / 100);
        }
        income -= upperPre;
        res += upperPre * (percent1 / 100);
        for (int i = 1; i < brackets.length  && income > 0; i++) {
            double upper = brackets[i][0] - upperPre;
            double percent = brackets[i][1];

            if(income <= upper) {
               res += income * (percent / 100);
               break;
            }
            res += upper * (percent / 100);
            income -= upper;
            upperPre = brackets[i][0];
        }
        return res;
    }
}
