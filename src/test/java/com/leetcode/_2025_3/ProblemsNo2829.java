package com.leetcode._2025_3;

import org.junit.Test;


/**
 * 2829. k-avoiding 数组的最小总和
 *
 * @author DHW
 * @date 2025/3/26 9: 08
 * @Version 1.0
*/
public class ProblemsNo2829 {

    @Test
    public void solution() {
        int n = 6;
        int k = 2;
        System.out.println("res = " + minimumSum(n, k));
    }

    public int minimumSum(int n, int k) {
        int res = 0;
        int pre = k / 2;
        for (int i = 1,j = 1; i <= n + k - pre && j <= n; i++) {
            if(i <= pre || i >= k) {
                res += i;
                j++;
            }
        }
        return res;
    }
}

