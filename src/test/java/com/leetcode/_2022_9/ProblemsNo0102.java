package com.leetcode._2022_9;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.02. 判定是否互为字符重排
 *
 *
 * @author DHW
 * @date 2022/9/27 10:29
 * @Version 1.0
*/
public class ProblemsNo0102 {

    @Test
    public void solution() {
        String s1 = "abc";
        String s2 = "bca";
        System.out.println("CheckPermutation() = " + CheckPermutation(s1, s2));
    }

    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> hashMap = new HashMap<>();
        char[] s1Chars = s1.toCharArray();
        for (char s1Char : s1Chars) {
            hashMap.put(s1Char, hashMap.getOrDefault(s1Char, 0) + 1);
        }

        char[] s2Chars = s2.toCharArray();
        for (char s2Char : s2Chars) {
            if(!hashMap.containsKey(s2Char)) {
                return false;
            }
            Integer num = hashMap.get(s2Char);
            if(num == 0) {
                return false;
            }
            hashMap.put(s2Char, num - 1);
        }
        return true;
    }
}
