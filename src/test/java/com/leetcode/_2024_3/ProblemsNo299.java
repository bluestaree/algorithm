package com.leetcode._2024_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


/**
 * 299. 猜数字游戏
 *
 * @author DHW
 * @date 2024/3/10 10:17
 * @Version 1.0
*/
public class ProblemsNo299 {

    @Test
    public void solution() {
        String secret = "6244988279";
        String guess = "3819888600";
        System.out.println("res = " + getHint(secret, guess));
    }

    public String getHint(String secret, String guess) {
        int x = 0, y = 0;
        int[] cnt1 = new int[10];
        int[] cnt2 = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            int a = secret.charAt(i) - '0', b = guess.charAt(i) - '0';
            if (a == b) {
                ++x;
            } else {
                ++cnt1[a];
                ++cnt2[b];
            }
        }
        for (int i = 0; i < 10; ++i) {
            y += Math.min(cnt1[i], cnt2[i]);
        }
        return String.format("%dA%dB", x, y);
    }

}

