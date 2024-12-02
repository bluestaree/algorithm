package com.leetcode._2024_11;

import org.junit.Test;


/**
 * 3222. 求出硬币游戏的赢家
 *
 * @author DHW
 * @date 2024/11/5 8: 27
 * @Version 1.0
*/
public class ProblemsNo3222 {

    @Test
    public void solution() {
        int x = 2;
        int y = 7;
        System.out.println("res = " + losingPlayer(x, y));
    }

    public String losingPlayer(int x, int y) {
        int num = Math.min(x, y / 4);
        return num % 2 == 0 ? "Bob" : "Alice";
    }
}

