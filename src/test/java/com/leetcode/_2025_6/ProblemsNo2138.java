package com.leetcode._2025_6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 2138. 将字符串拆分为若干长度为 k 的组
 *
 * @author DHW
 * @date 2025/6/22 9: 55
 * @Version 1.0
*/
public class ProblemsNo2138 {

    @Test
    public void solution() {
        String s = "abcdefghi";
        int k = 3;
        char fill = 'x';
        System.out.println("res = " + divideString(s, k, fill));
    }

    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        if (n % k != 0) {
            int r = k - n % k;
            for (int i = 0; i < r; ++i) {
                sb.append(fill);
            }
        }
        int len = sb.length() / k;
        String[] ans = new String[len];
        for (int i = 0; i < len; ++i) {
            ans[i] = sb.substring(i * k, (i + 1) * k);
        }
        return ans;
    }
}

