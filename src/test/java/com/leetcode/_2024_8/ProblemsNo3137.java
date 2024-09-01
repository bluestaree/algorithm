package com.leetcode._2024_8;

import com.sun.javafx.image.IntPixelGetter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


/**
 * 3137. K 周期字符串需要的最少操作次数
 *
 * @author DHW
 * @date 2024/8/17 10:35
 * @Version 1.0
*/
public class ProblemsNo3137 {

    @Test
    public void solution() {
        String word = "leetcodeleet";
        int k = 4;
        System.out.println("res = " + minimumOperationsToMakeKPeriodic(word, k));
    }

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i+=k) {
            String s = word.substring(i, i + k);
            map.merge(s, 1, Integer::sum);
        }
        int res = map.values().stream().sorted((a,b)->b-a).skip(1).mapToInt(Integer::intValue).sum();
        return res;
    }
}

