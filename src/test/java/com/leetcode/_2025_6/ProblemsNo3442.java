package com.leetcode._2025_6;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 * 3442. 奇偶频次间的最大差值 I
 *
 * @author DHW
 * @date 2025/6/10 8: 37
 * @Version 1.0
*/
public class ProblemsNo3442 {

    @Test
    public void solution() {
        String s = "cgokcgerolkgksgbhgmaaealacnsshofjinidiigbjerdnkolc";
        System.out.println("res = " + maxDifference(s));
    }

    public int maxDifference(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        int min = Integer.MAX_VALUE;;
        int max = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() % 2 == 0) {
                min = Math.min(min, entry.getValue());
            } else {
                max = Math.max(max, entry.getValue());
            }
        }
        return max - min;
    }
}

