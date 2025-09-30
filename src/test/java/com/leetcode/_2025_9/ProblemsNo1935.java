package com.leetcode._2025_9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


/**
 * 1935. 可以输入的最大单词数
 *
 * @author DHW
 * @date 2025/9/15 9: 18
 * @Version 1.0
*/
public class ProblemsNo1935 {

    @Test
    public void solution() {
        String text = "hello world";
        String brokenLetters = "ad";
        System.out.println("res = " + canBeTypedWords(text, brokenLetters));
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] s = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            s[c - 'a'] = true;
        }
        int ans = 0;
        for (String w : text.split(" ")) {
            for (char c : w.toCharArray()) {
                if (s[c - 'a']) {
                    --ans;
                    break;
                }
            }
            ++ans;
        }
        return ans;
    }
}

