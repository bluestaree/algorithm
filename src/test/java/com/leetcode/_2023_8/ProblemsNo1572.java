package com.leetcode._2023_8;

import org.junit.Test;


/**
 * 1572. 矩阵对角线元素的和
 *
 * @author DHW
 * @date 2023/8/11 9:44
 * @Version 1.0
*/
public class ProblemsNo1572 {

    @Test
    public void solution() {
        int[][] mat = new int[][]{new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}};
        System.out.println("res = " + diagonalSum(mat));
    }

    public int diagonalSum(int[][] mat) {
        int len = mat.length;
        int res = 0;
        int primaryIndex = 0;
        int secondaryIndex = len - 1;
        for (int i = 0; i < len; i++) {
            if(primaryIndex == secondaryIndex) {
                res += mat[i][primaryIndex];
            } else {
                res += mat[i][primaryIndex];
                res += mat[i][secondaryIndex];
            }
            primaryIndex++;
            secondaryIndex--;
        }
        return res;
    }
}
