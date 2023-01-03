package com.leetcode._2022_12;

import org.junit.Test;

import java.util.HashSet;
import java.util.regex.Pattern;


/**
 * 1805. 字符串中不同整数的数目
 *
 * @author DHW
 * @date 2022/12/6 16:29
 * @Version 1.0
*/
public class ProblemsNo1805 {

    @Test
    public void solution() {
        String word = "01a001b1c2";
        System.out.println("res = " + numDifferentIntegers(word));
    }

    public int numDifferentIntegers(String word) {
        String s = word.replaceAll("[a-z]+", " ");
        String[] split = s.split(" ");
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < split.length; i++) {
            if(split[i].matches("-?[0-9]+.?[0-9]*")) {
                int index = 0;
                char[] chars = split[i].toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    if(chars[j] != '0') {
                        break;
                    }
                    index++;
                }
                set.add(split[i].substring(index));
            }
        }
        return set.size();
    }
}
