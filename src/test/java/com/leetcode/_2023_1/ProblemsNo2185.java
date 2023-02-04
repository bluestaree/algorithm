package com.leetcode._2023_1;

import org.junit.Test;


/**
 * 2185. 统计包含给定前缀的字符串
 *
 * @author DHW
 * @date 2023/1/8 11:02
 * @Version 1.0
*/
public class ProblemsNo2185 {

    @Test
    public void solution() {
        String[] words = new String[]{"pay","attention","practice","attend"};
        String s = "at";
        System.out.println("res = " + prefixCount(words, s));
    }

    public int prefixCount(String[] words, String pref) {
        int res = 0;
        char[] toCharArray = pref.toCharArray();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(word.length() < pref.length()) {
                continue;
            }
            boolean flag = true;
            char[] chars = word.toCharArray();
            for (int j = 0; j < pref.length(); j++) {
                if(chars[j] != toCharArray[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }
}
