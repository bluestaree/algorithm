package com.leetcode._2026_1;

import org.junit.Test;

import java.util.HashMap;


/**
 * 1234. 替换子串得到平衡字符串
 *
 * @author DHW
 * @date 2026/1/14 13: 56
 * @Version 1.0
*/
public class ProblemsNo1234 {

    @Test
    public void solution() {
        String s = "QWER";
        System.out.println("res = " + balancedString(s));
    }

    public int balancedString(String s) {
        int[] count = new int['X'];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int n = s.length();
        int required = n / 4;
        if (count['Q'] == required && count['W'] == required && count['E'] == required && count['R'] == required) {
            return 0;
        }
        int ans = n;
        int l = 0;
        for (int r = 0; r < n; r++) {
            count[s.charAt(r)]--;
            while (count['Q'] <= required && count['W'] <= required && count['E'] <= required && count['R'] <= required) {
                ans = Math.min(ans, r - l + 1);
                count[s.charAt(l)]++;
                l++;
            }
        }
        return ans;
    }
}

