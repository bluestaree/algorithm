package com.leetcode._2026_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3014. 输入单词需要的最少按键次数 I
 *
 * @author DHW
 * @date 2026/7/30 8:47
 * @Version 1.0
*/
public class ProblemsNo3014 {

    @Test
    public void solution() {
        String s = "bbb";
        System.out.println("res = " + minimumPushes(s));
    }

    public int minimumPushes(String word) {
        int ans = 0;
        int cnt = 1;
        int n = word.length();
        while (true) {
            if(n > 8) {
                ans += cnt * 8;
                n -= 8;
            } else {
                ans += cnt * n;
                break;
            }
            cnt++;
        }
        return ans;
    }

}
