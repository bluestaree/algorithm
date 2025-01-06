package com.leetcode._2024_12;

import org.junit.Test;


/**
 * 3001. 捕获黑皇后需要的最少移动次数
 *
 * @author DHW
 * @date 2024/12/5 8: 44
 * @Version 1.0
*/
public class ProblemsNo3001 {

    @Test
    public void solution() {
        System.out.println("res = " + minMovesToCaptureTheQueen(6, 7, 5, 6, 7, 4));
    }

    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int x = 8;
        int y = 8;
        if(Math.abs(c - e) == Math.abs(d - f)) {
            x = 1;
            if(Math.abs(a - e) == Math.abs(b - f) && (a - e) * (c - e) > 0 && (b - f) * (d - f) > 0 && Math.abs(a - e) < Math.abs(c - e)) {
                x +=1;
            }
        }
        if(a == e || b == f) {
            y = 1;
            if(a == c && ((b < d && d < f) || (b > d && d > f))) {
                y = 2;
            }
            if(b == d && ((a < c && c < e) || (a > c && c > e))) {
                y = 2;
            }
        } else {
            y = 2;
        }
        return Math.min(x,y);
    }
}

