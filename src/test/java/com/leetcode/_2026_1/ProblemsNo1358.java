package com.leetcode._2026_1;

import org.junit.Test;


/**
 * 1358. 包含所有三种字符的子字符串数目
 *
 * @author DHW
 * @date 2026/1/22 10: 33
 * @Version 1.0
*/
public class ProblemsNo1358 {

    @Test
    public void solution() {
        String s = "aaacb";
        System.out.println("res = " + numberOfSubstrings(s));
    }

    public int numberOfSubstrings(String s) {
        int ans = 0;
        int l = 0;
        int[] count = new int[3];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            while(count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(l) - 'a']--;
                l++;
            }
            ans += l;
        }
        return ans;
    }
}

