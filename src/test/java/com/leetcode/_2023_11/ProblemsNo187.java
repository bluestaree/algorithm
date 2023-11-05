package com.leetcode._2023_11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 187. 重复的DNA序列
 *
 * @author DHW
 * @date 2023/11/5 11:32
 * @Version 1.0
 */
public class ProblemsNo187 {

    @Test
    public void solution() {
        String rings = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println("minimum = " + findRepeatedDnaSequences(rings));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 10 + 1; ++i) {
            String t = s.substring(i, i + 10);
            Integer num = map.getOrDefault(t, 0);
            map.put(t, num + 1);
            if (num == 1) {
                res.add(t);
            }
        }
        return res;
    }
}