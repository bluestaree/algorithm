package com.leetcode._2024_11;

import org.junit.Test;


/**
 * 661. 图片平滑器
 *
 * @author DHW
 * @date 2024/11/18 9: 08
 * @Version 1.0
*/
public class ProblemsNo661 {

    @Test
    public void solution() {
        int[][] img = new int[][]{new int[]{100,200,100},new int[]{200,50,200},new int[]{100,200,100}};
        System.out.println("res = " + imageSmoother(img));
    }

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int x = i-1; x <= i+1; x++) {
                    for (int y = j-1; y <= j+1; y++) {
                        if(x >= 0 && x < m && y >= 0 && y < n) {
                            count++;
                            res[i][j] += img[x][y];
                        }
                    }
                }
                res[i][j] /= count;
            }
        }
        return res;
    }
}

