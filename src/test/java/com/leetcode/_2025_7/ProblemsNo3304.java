package com.leetcode._2025_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 3304. 找出第 K 个字符 I
 *
 * @author DHW
 * @date 2025/7/3 8: 55
 * @Version 1.0
*/
public class ProblemsNo3304 {

    @Test
    public void solution() {
        int k = 5;
        System.out.println("res = " + kthCharacter(k));
    }

    public char kthCharacter(int k) {
        List<Integer> word = new ArrayList<>();
        word.add(0);
        while (word.size() < k) {
            for (int i = 0, m = word.size(); i < m; ++i) {
                word.add((word.get(i) + 1) % 26);
            }
        }
        return (char) ('a' + word.get(k - 1));
    }

}

