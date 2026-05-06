package com.leetcode._2026_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 524. 通过删除字母匹配到字典里最长单词
 *
 * @author DHW
 * @date 2026/4/15 10: 24
 * @Version 1.0
 */
public class ProblemsNo524 {

    @Test
    public void solution() {
        String s = "abpcplea";
        List<String> dictionary = new ArrayList<String>();
        dictionary.add("apple");
        System.out.println("res = " + findLongestWord(s, dictionary));
    }

    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (a,b)->{
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });
        int n = s.length();
        for (String ss : dictionary) {
            int m = ss.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) == ss.charAt(j)) j++;
                i++;
            }
            if (j == m) return ss;
        }
        return "";
    }
}

