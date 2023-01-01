package com.leetcode._2023_1;

import org.junit.Test;

import java.util.HashSet;


/**
 * 2351. 第一个出现两次的字母
 *
 * @author DHW
 * @date 2023/1/1 10:30
 * @Version 1.0
*/
public class ProblemsNo2351 {

    @Test
    public void solution() {
        String s = "abccbaacz";
        System.out.println("res = " + repeatedCharacter(s));
    }

    public char repeatedCharacter(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(count[chars[i] - 'a'] == 1) {
                return chars[i];
            }
            count[chars[i] - 'a'] = 1;
        }
        return chars[0];
    }
}
