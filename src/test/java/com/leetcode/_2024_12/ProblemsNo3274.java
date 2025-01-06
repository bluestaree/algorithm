package com.leetcode._2024_12;

import org.junit.Test;


/**
 * 3274. 检查棋盘方格颜色是否相同
 *
 * @author DHW
 * @date 2024/12/3 8: 35
 * @Version 1.0
*/
public class ProblemsNo3274 {

    @Test
    public void solution() {
        String x = "a1";
        String y = "c3";
        System.out.println("res = " + checkTwoChessboards(x, y));
    }

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int x = coordinate1.charAt(0) - coordinate2.charAt(0);
        int y = coordinate1.charAt(1) - coordinate2.charAt(1);
        return (x + y) % 2 == 0;
    }
}

