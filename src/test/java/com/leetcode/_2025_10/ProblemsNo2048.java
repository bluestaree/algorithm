package com.leetcode._2025_10;

import org.junit.Test;


/**
 * 2048. 下一个更大的数值平衡数
 *
 * @author DHW
 * @date 2025/10/24 8: 48
 * @Version 1.0
*/
public class ProblemsNo2048 {

    @Test
    public void solution() {
        int n = 1000;
        System.out.println("res = " + nextBeautifulNumber(n));
    }

    public int nextBeautifulNumber(int n) {
        int ans = n + 1;
        for (; ; ans++) {
            int[] cnt = new int[10];
            boolean flag = true;
            for (int i = ans; i > 0; i /= 10) {
                int j = i  % 10;
                if(j > 6 || j == 0) {
                    flag = false;
                    break;
                }
                cnt[j]++;
            }
            if(!flag) {
                continue;
            }
            for (int i = ans; i > 0; i /= 10) {
                int j = i % 10;
                if(cnt[j] != j) {
                    flag = false;
                    break;
                }
            }
            if(!flag) {
                continue;
            }
            return ans;
        }
    }
}

