package com.leetcode._2023_6;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 2490. 回环句
 *
 * @author DHW
 * @date 2023/6/30 8:44
 * @Version 1.0
*/
public class ProblemsNo2490 {

    @Test
    public void solution() {
        String sentence = "leetcode exercises sound delightful";

        System.out.println("res = " + isCircularSentence(sentence));
    }

    public boolean isCircularSentence(String sentence) {
        char firstChar = sentence.charAt(0);
        char lastChar = sentence.charAt(sentence.length() - 1);
        if(firstChar != lastChar) {
            return false;
        }
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length - 1; i++) {
            if(i + 1 < s.length && s[i + 1].charAt(0) != s[i].charAt(s[i].length() - 1)) {
                return false;
            }
        }
        return true;
    }
}
