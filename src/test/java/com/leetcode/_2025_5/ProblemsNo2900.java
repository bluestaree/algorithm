package com.leetcode._2025_5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * 2900. 最长相邻不相等子序列 I
 *
 * @author DHW
 * @date 2025/5/15 8: 34
 * @Version 1.0
*/
public class ProblemsNo2900 {

    @Test
    public void solution() {
        String[] words = new String[]{"a","b","c","d"};
        int[] groups = new int[]{1,0,1,1};
        System.out.println("res = " + getLongestSubsequence(words, groups));
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        int t = groups[0];
        for (int i = 1; i < groups.length; i++) {
            if(t != groups[i]) {
                res.add(words[i]);
                t = groups[i];
            }
        }
        return res;
    }
}

