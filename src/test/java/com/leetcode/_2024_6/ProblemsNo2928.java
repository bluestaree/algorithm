package com.leetcode._2024_6;

import org.junit.Test;


/**
 * 2928. 给小朋友们分糖果 I
 *
 * @author DHW
 * @date 2024/6/1 11:47
 * @Version 1.0
*/
public class ProblemsNo2928 {

    @Test
    public void solution() {
        int n = 5;
        int limit = 5;
        System.out.println("res = " + distributeCandies(n, limit));
    }

    public int distributeCandies(int n, int limit) {
        int ans = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                if (i + j > n) {
                    break;
                }
                if (n - i - j <= limit) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

