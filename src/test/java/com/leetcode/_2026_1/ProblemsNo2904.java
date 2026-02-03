package com.leetcode._2026_1;

import org.junit.Test;


/**
 * 2904. 最短且字典序最小的美丽子字符串
 *
 * @author DHW
 * @date 2026/1/14 8: 45
 * @Version 1.0
*/
public class ProblemsNo2904 {

    @Test
    public void solution() {
        String s = "001";
        int k = 1;
        System.out.println("res = " + shortestBeautifulSubstring(s, k));
    }

    public String shortestBeautifulSubstring(String s, int k) {
        if (s.replace("0", "").length() < k) {
            return "";
        }
        String ans = s;
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int cur = k;
        for (int r = 0; r < s.length(); r++) {
            sb.append(s.charAt(r));
            if(s.charAt(r) == '1') {
                cur--;
            }
            while(cur < 0 || (cur == 0 && s.charAt(left) == '0')) {
                if(s.charAt(left) == '1') {
                    cur++;
                }
                sb.deleteCharAt(0);
                left++;
            }
            if(cur == 0) {
                String t = sb.toString();
                if (t.length() < ans.length() || t.length() == ans.length() && t.compareTo(ans) < 0) {
                    ans = t;
                }
            }
        }
        return ans;
    }
}

