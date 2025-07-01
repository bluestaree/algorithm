package com.leetcode._2025_6;

import org.junit.Test;

import java.util.PriorityQueue;


/**
 * 3403. 从盒子中找出字典序最大的字符串 I
 *
 * @author DHW
 * @date 2025/6/4 8: 47
 * @Version 1.0
*/
public class ProblemsNo3403 {

    @Test
    public void solution() {
        String word = "dah";
        int numFriends = 3;
        System.out.println("res = " + answerString(word, numFriends));
    }

    public String answerString(String word, int numFriends) {
        if(numFriends == 1) {
            return word;
        }
        int n = word.length();
        String res = "";
        for (int i = 0; i < n; ++i) {
            String t = word.substring(i, Math.min(n, i + (n - numFriends + 1)));
            if (res.compareTo(t) < 0) {
                res = t;
            }
        }
        return res;
    }
}

