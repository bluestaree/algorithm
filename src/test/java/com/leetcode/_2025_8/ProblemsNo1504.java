package com.leetcode._2025_8;

import org.junit.Test;


/**
 * 1504.统计全 1 子矩形
 *
 * @author DHW
 * @date 2025/8/21 9: 26
 * @Version 1.0
*/
public class ProblemsNo1504 {

    @Test
    public void solution() {
        int[][] mat =  new int[][]{new int[]{0,1,1,0},new int[]{0,1,1,1},new int[]{1,1,1,0}};
        System.out.println("res = " + numSubmat(mat));
    }


    public int numSubmat(int[][] mat) {
        int ans = 0;
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] != 1) {
                    continue;
                }
                ans++;
                int acount = 0;
                for (int a = i + 1; a < m; a++) {
                    if(mat[a][j] != 1) {
                        break;
                    }
                    acount++;
                }
                ans += acount;
                int bcount = 0;
                for (int b = j + 1; b < n; b++) {
                    if(mat[i][b] != 1) {
                        break;
                    }
                    bcount++;
                }
                ans += bcount;
                for (int k = 1; k <= acount && bcount > 0; k++) {
                    for (int l = 1; l <= bcount; l++) {
                        if(mat[k + i][l + j] != 1) {
                            bcount = l - 1;
                            break;
                        }
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}

