package com.leetcode._2026_1;

import org.junit.Test;


/**
 * 3325. 字符至少出现 K 次的子字符串 I
 *
 * @author DHW
 * @date 2026/1/29 11: 00
 * @Version 1.0
*/
public class ProblemsNo3325 {

    @Test
    public void solution() {
        String s = "abacb";
        int k = 2;
        System.out.println("res = " + numberOfSubstrings(s, k));
    }

    public int numberOfSubstrings(String s, int k) {
        int ans = 0;
        char[] charArray = s.toCharArray();
        int[] count = new int[26];
        int left = 0;
        for (int right = 0; right < charArray.length; right++) {
            count[charArray[right] - 'a']++;
            while (count[charArray[right] - 'a'] == k) {
                count[charArray[left] - 'a']--;
                left++;
            }
            ans += left;
        }
        return ans;
    }
}

