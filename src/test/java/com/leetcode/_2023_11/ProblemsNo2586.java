package com.leetcode._2023_11;

import org.junit.Test;


/**
 * 2586. 统计范围内的元音字符串数
 *
 * @author DHW
 * @date 2023/11/7 10:10
 * @Version 1.0
 */
public class ProblemsNo2586 {

    @Test
    public void solution() {
        String[] words = new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        int left = 0;
        int right = 1;
        System.out.println("minimum = " + vowelStrings(words, left, right));
    }

    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if(check(word.charAt(0)) && check(word.charAt(word.length() - 1))) {
                res++;
            }
        }
        return res;
    }
    private boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}