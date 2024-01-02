package com.leetcode._2023_12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 2828. 判别首字母缩略词
 *
 * @author DHW
 * @date 2023/12/20 10:12
 * @Version 1.0
*/
public class ProblemsNo2828 {

    @Test
    public void solution() {
        List<String> words = new ArrayList<>();
        words.add("a");
        words.add("b");
        words.add("c");
        String s = "abc";
        System.out.println("res = " + isAcronym(words, s));
    }

    public boolean isAcronym(List<String> words, String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if(words.size() != n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if(words.get(i).charAt(0) != chars[i]) {
                return false;
            }
        }
        return true;
    }
}

