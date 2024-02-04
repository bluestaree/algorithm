package com.leetcode._2024_1;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 2085. 统计出现过一次的公共字符串
 *
 * @author DHW
 * @date 2024/1/12 9:15
 * @Version 1.0
*/
public class ProblemsNo2085 {

    @Test
    public void solution() {
        String[] words1 = new String[]{"dd"};
        String[] words2 = new String[]{"dd"};
        System.out.println("res = " + countWords(words1, words2));
    }

    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (String s : words1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for (String s : words2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if(entry.getValue() == 1 &&  map2.getOrDefault(entry.getKey(), 0) == 1) {
                res++;
            }
        }
        return res;
    }
}

