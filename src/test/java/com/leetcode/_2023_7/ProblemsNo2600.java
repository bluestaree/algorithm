package com.leetcode._2023_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2600. K 件物品的最大和
 *
 * @author DHW
 * @date 2023/7/5 11:05
 * @Version 1.0
*/
public class ProblemsNo2600 {

    @Test
    public void solution() {
        int numOnes = 3;
        int numZeros = 2;
        int numNegOnes = 1;
        int k = 6;
        System.out.println("res = " + kItemsWithMaximumSum(numOnes, numZeros, numNegOnes, k));
    }

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        } else if (k <= numOnes + numZeros) {
            return numOnes;
        } else {
            return numOnes - (k - numOnes - numZeros);
        }
    }
}
