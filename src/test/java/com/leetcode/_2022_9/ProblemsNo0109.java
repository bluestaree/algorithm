package com.leetcode._2022_9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 0109. 零矩阵
 *
 * @author DHW
 * @date 2022/9/30 9:37
 * @Version 1.0
*/
public class ProblemsNo0109 {

    @Test
    public void solution() {
        int[][] matrix = new int[3][3];
        int[] i1 = new int[]{1,1,1};
        int[] i2 = new int[]{1,0,1};
        int[] i3 = new int[]{1,1,1};
        matrix[0] = i1;
        matrix[1] = i2;
        matrix[2] = i3;
        setZeroes(matrix);
        System.out.println("i3 = " + matrix);
    }

    public void setZeroes(int[][] matrix) {
        int[][] setZero = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            setZero[i] = new int[matrix[0].length];
        }
        for (int i = 0; i < matrix.length; i++) {
            int[] ints = matrix[i];
            boolean hasFill = false;
            for (int j = 0; j < ints.length; j++) {
                if(ints[j] == 0) {
                    if(!hasFill) {
                        Arrays.fill(setZero[i], 1);
                        hasFill = true;
                    }
                    // 填充列
                    for (int k = 0; k < matrix.length; k++) {
                        setZero[k][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < setZero.length; i++) {
            int[] ints = setZero[i];
            for (int j = 0; j < ints.length; j++) {
                if(setZero[i][j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
