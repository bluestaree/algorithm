package com.leetcode._2025_6;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 1061. 按字典序排列最小的等效字符串
 *
 * @author DHW
 * @date 2025/6/5 8: 34
 * @Version 1.0
*/
public class ProblemsNo1061 {

    @Test
    public void solution() {
        String s1 = "cgokcgerolkgksgbhgmaaealacnsshofjinidiigbjerdnkolc";
        String s2 = "rjjlkbmnprkslilqmbnlasardrossiogrcboomrbcmgmglsrsj";
        String baseStr = "bxbwjlbdazfejdsaacsjgrlxqhiddwaeguxhqoupicyzfeupcn";
        System.out.println("res = " + smallestEquivalentString(s1, s2, baseStr));
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] fa = new int[26];
        for (int i = 0; i < 26; i++) {
            fa[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            merge(fa, s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        char[] s = baseStr.toCharArray();
        for (int i = 0; i < s.length; i++) {
            s[i] = (char) (find(fa, s[i] - 'a') + 'a');
        }
        return new String(s);
    }

    private int find(int[] fa, int x) {
        if (fa[x] != x) {
            fa[x] = find(fa, fa[x]);
        }
        return fa[x];
    }

    private void merge(int[] fa, int x, int y) {
        int fx = find(fa, x);
        int fy = find(fa, y);
        // 把大的代表元指向小的代表元
        if (fx < fy) {
            fa[fy] = fx;
        } else {
            fa[fx] = fy;
        }
    }
}

