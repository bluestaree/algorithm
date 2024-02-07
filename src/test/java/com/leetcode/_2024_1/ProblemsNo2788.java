package com.leetcode._2024_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 2788. 按分隔符拆分字符串
 *
 * @author DHW
 * @date 2024/1/20 11:29
 * @Version 1.0
*/
public class ProblemsNo2788 {

    @Test
    public void solution() {
        List<String> words = new ArrayList<>();
        words.add("$easy$");
        words.add("$problem$");
        char separator = '$';
        System.out.println("res = " + splitWordsBySeparator(words, separator));
    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if(chars[i] == separator) {
                    if(sb.length() > 0) {
                        res.add(sb.toString());
                        sb.delete(0, sb.length());
                    }
                    continue;
                }
                sb.append(chars[i]);
            }
            if(sb.length() > 0) {
                res.add(sb.toString());
            }
        }
        return res;
    }
}

