package com.leetcode._2024_1;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;


/**
 * 2744. 最大字符串配对数目
 *
 * @author DHW
 * @date 2024/1/17 9:27
 * @Version 1.0
*/
public class ProblemsNo2744 {

    @Test
    public void solution() {
        String[] words = new String[]{"cd","ac","dc","ca","zz"};
        System.out.println("res = " + maximumNumberOfStringPairs(words));
    }

    public int maximumNumberOfStringPairs(String[] words) {
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        int res = 0;
        for (String word : words) {
            if(set.contains(word)) {
                res++;
                continue;
            }
            char[] chars = word.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                sb.append(chars[i]);
            }
            set.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return res;
    }
}

