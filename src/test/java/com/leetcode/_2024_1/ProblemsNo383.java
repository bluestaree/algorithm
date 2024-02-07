package com.leetcode._2024_1;

import org.junit.Test;

import java.util.HashMap;


/**
 * 383. 赎金信
 *
 * @author DHW
 * @date 2024/1/7 12:05
 * @Version 1.0
*/
public class ProblemsNo383 {

    @Test
    public void solution() {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println("res = " + canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); ++i) {
            ++cnt[magazine.charAt(i) - 'a'];
        }
        for (int i = 0; i < ransomNote.length(); ++i) {
            if (--cnt[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

