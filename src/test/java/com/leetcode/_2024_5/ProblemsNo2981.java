package com.leetcode._2024_5;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * 2981. 找出出现至少三次的最长特殊子字符串 I
 *
 * @author DHW
 * @date 2024/5/29 9:16
 * @Version 1.0
*/
public class ProblemsNo2981 {

    @Test
    public void solution() {
        String s = "sawd";
        System.out.println("res = " + maximumLength(s));
    }

    public int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if(s.charAt(j) == s.charAt(i)) {
                    String cur = s.substring(i,j+1);
                    map.put(cur,map.getOrDefault(cur,0)+1);
                    continue;
                }
                break;
            }
        }

        int res = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() >= 3) {
                res = Math.max(res, entry.getKey().length());
            }

        }
        return res;
    }
}

