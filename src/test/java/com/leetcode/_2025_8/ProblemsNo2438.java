package com.leetcode._2025_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 2438. 二的幂数组中查询范围内的乘积
 *
 * @author DHW
 * @date 2025/8/11 9: 12
 * @Version 1.0
*/
public class ProblemsNo2438 {

    @Test
    public void solution() {
        int n = 15;
        int[][] queries =  new int[][]{new int[]{0,1},new int[]{2,2},new int[]{0,3}};
        System.out.println("res = " + productQueries(n, queries));
    }

    public int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;
        int[] a = new int[31];
        a[0] = 1;
        for (int i = 0; i < 30; i++) {
            a[i+1] = 2 << i;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = a.length - 1; i >= 0; i--) {
            if(n >= a[i]) {
                n -= a[i];
                list.add(a[i]);
            }
        }
        int len = queries.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            long tem = 1l;
            for (int j = l; j <= r; j++) {
                tem = (list.get(list.size() - 1 - j) * tem) % mod;
            }
            ans[i] = (int) tem;
        }
        return ans;
    }
}

