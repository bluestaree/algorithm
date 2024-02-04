package com.leetcode._2024_2;

import org.junit.Test;


/**
 * 292. Nim 游戏
 *
 * @author DHW
 * @date 2024/2/4 9:26
 * @Version 1.0
*/
public class ProblemsNo292 {

    @Test
    public void solution() {
        System.out.println("res = " + canWinNim(12));
    }

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}

