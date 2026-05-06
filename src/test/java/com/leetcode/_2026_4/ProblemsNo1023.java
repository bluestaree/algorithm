package com.leetcode._2026_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 1023. 驼峰式匹配
 *
 * @author DHW
 * @date 2026/4/20 11: 10
 * @Version 1.0
 */
public class ProblemsNo1023 {

    @Test
    public void solution() {
        String[] queries = new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FB";
        System.out.println("res = " + camelMatch(queries, pattern));
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int n = queries.length;
        int m = pattern.length();
        ArrayList<Boolean> ans = new ArrayList<>(n);
        for (int k = 0; k < n; k++) {
            String s = queries[k];
            int i = 0, j = 0;
            int l = s.length();
            while (i < l) {
                if(s.charAt(i) < 'a' && (j == m || pattern.charAt(j) != s.charAt(i))) {
                    break;
                }
                if (j < m && s.charAt(i) == pattern.charAt(j)) {
                    j++;
                }
                i++;
            }
            ans.add(i == l && j == m);
        }
        return ans;
    }
}

