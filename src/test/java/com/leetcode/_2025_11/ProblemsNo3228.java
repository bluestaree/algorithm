package com.leetcode._2025_11;

import org.junit.Test;


/**
 * 3228. 将 1 移动到末尾的最大操作次数
 *
 * @author DHW
 * @date 2025/11/13 8: 44
 * @Version 1.0
*/
public class ProblemsNo3228 {

    @Test
    public void solution() {
        String s = "00111";
        System.out.println("res = " + maxOperations(s));
    }

    public int maxOperations(String s) {
        int length = s.length();
        int[] a = new int[length + 1];
        for (int i = 0; i < length; i++) {
            a[i+1] = a[i] + (s.charAt(i) - '0');
        }

        int ans = 0;
        for (int i = length - 1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                ans += a[i];
                while(i > 0) {
                    if(s.charAt(i - 1) == '1') {
                        break;
                    }
                    i--;
                }
            }
        }
        return ans;
    }
}

