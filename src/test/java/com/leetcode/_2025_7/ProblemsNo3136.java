package com.leetcode._2025_7;

import org.junit.Test;


/**
 * 3136. 有效单词
 *
 * @author DHW
 * @date 2025/7/15 9: 22
 * @Version 1.0
*/
public class ProblemsNo3136 {

    @Test
    public void solution() {
        String word = "abbcccc";
        System.out.println("res = " + isValid(word));
    }

    public boolean isValid(String word) {
        int n = word.length();
        if (n < 3) {
            return false;
        }
        char[] charArray = word.toCharArray();
        boolean a = false;
        boolean b = false;
        for (char c : charArray) {
            if(c >= 48 && c <= 57) {
                continue;
            }
            if(c >= 65 && c <= 90) {
                if(c == 65 || c == 69 ||  c == 73 || c == 79 || c == 85) {
                    a = true;
                } else {
                    b = true;
                }
                continue;
            }
            if(c >= 97 && c <= 122) {
                if(c == 97 || c == 101 ||  c == 105 || c == 111 || c == 117) {
                    a = true;
                } else {
                    b = true;
                }
                continue;
            }
            return false;
        }
        return a && b;
    }
}

