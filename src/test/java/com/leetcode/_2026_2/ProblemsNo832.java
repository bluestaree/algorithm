package com.leetcode._2026_2;

import org.junit.Test;


/**
 * 832. 翻转图像
 *
 * @author DHW
 * @date 2026/2/25 9:38
 * @Version 1.0
 */
public class ProblemsNo832 {

    @Test
    public void solution() {
        int[][] image = new int[][]{new int[]{1, 2}, new int[]{2, 3}};
        System.out.println("res = " + flipAndInvertImage(image));
    }

    public int[][] flipAndInvertImage(int[][] image) {
        int m = image.length;
        int n = image[0].length;
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l <= r) {
                if(l == r) {
                    image[i][l] = image[i][l] == 0 ? 1 : 0;
                    break;
                }
                int temp = image[i][l];
                image[i][l] = image[i][r] == 0 ? 1 : 0;
                image[i][r] = temp == 0 ? 1 : 0;
                l++;
                r--;
            }
        }
        return image;
    }
}
