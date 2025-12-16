package com.leetcode._2025_12;

import org.junit.Test;


/**
 * 1925. 统计平方和三元组的数目
 *
 * @author DHW
 * @date 2025/12/8 8: 44
 * @Version 1.0
*/
public class ProblemsNo1925 {

    @Test
    public void solution() {
        int n = 3;
        System.out.println("res = " + countTriples(n));
    }

    public int countTriples(int n) {
        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int x = i * i + j * j;
                int k = (int) Math.sqrt(x);
                if(k * k == x && k <= n) {
                    ans++;
                }
            }
        }
        return ans;
    }

}

