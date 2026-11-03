package com.leetcode._2026_10;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


/**
 * 1930. 长度为 3 的不同回文子序列
 *
 * @author DHW
 * @date 2026/10/26 9:25
 * @Version 1.0
*/
public class ProblemsNo1930 {

    @Test
    public void solution() {
        String s = "abcde";
        System.out.println("res = " + countPalindromicSubsequence(s));
    }

    public int countPalindromicSubsequence(String s) {
        int[][] cnt = new int[26][1];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            cnt[charArray[i] - 'a'][0]++;
        }
        int[][] prev = new int[26][1];
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < charArray.length; i++) {
            int idx = charArray[i] - 'a';
            cnt[idx][0]--;
            for (int j = 0; j < 26; j++) {
                if(prev[j][0] > 0 && cnt[j][0] > 0) {
                    set.add((char)(j + 'a') + "" + charArray[i] + (char)(j + 'a'));
                }
            }
            prev[idx][0]++;
        }
        return set.size();
    }
}

