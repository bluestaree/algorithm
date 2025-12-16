package com.leetcode._2025_12;

import org.junit.Test;

import java.util.HashMap;


/**
 * 1423. 可获得的最大点数
 *
 * @author DHW
 * @date 2025/12/5 9: 37
 * @Version 1.0
*/
public class ProblemsNo1423 {

    @Test
    public void solution() {
        int[] cardPoints =  new int[]{1,2,3,4,5,6,1};
        int k = 3;
        System.out.println("res = " + maxScore(cardPoints, k));
    }

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        int m = n - k;
        for (int i = 0; i < m; i++) {
            sum += cardPoints[i];
        }
        int total = sum;
        int minSum = sum;
        for (int i = m; i < n; i++) {
            total += cardPoints[i];
            sum -= cardPoints[i - m];
            sum += cardPoints[i];
            minSum = Math.min(minSum, sum);
        }
        return total - minSum;
    }

}

