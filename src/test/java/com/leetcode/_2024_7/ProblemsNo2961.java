package com.leetcode._2024_7;

import org.junit.Test;

import java.util.*;


/**
 * 2961. 双模幂运算
 *
 * @author DHW
 * @date 2024/7/30 9:46
 * @Version 1.0
*/
public class ProblemsNo2961 {

    @Test
    public void solution() {
        int[][] variables = new int[][]{new int[]{0,1,10},new int[]{1,2,15},new int[]{0,3,10}};
        int target = 4;
        System.out.println("res = " + getGoodIndices(variables, target));
    }

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] variable = variables[i];
            if(pow(pow(variable[0], variable[1], 10), variable[2], variable[3]) == target) {
                list.add(i);
            }
        }
        return list;
    }

    private int pow(int a, int b, int mod) {
        int res = 1;
        while(b > 0) {
            if((b & 1) == 1) {
                res = res * a % mod ;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}


