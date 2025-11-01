package com.leetcode._2025_9;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;


/**
 * 966. 元音拼写检查器
 *
 * @author DHW
 * @date 2025/9/14 10: 33
 * @Version 1.0
*/
public class ProblemsNo966 {

    @Test
    public void solution() {
        String[] wordlist = new String[]{"KiTe","kite","hare","Hare"};
        String[] queries = new String[]{"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        System.out.println("res = " + spellchecker(wordlist, queries));
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n = queries.length;
        String[] ans = new String[n];
        HashSet<String> set = new HashSet<>();
        HashMap<String, String> low  = new HashMap<>();
        HashMap<String, String> pat = new HashMap<>();
        for (String s : wordlist) {
            set.add(s);
            String lowerCase = s.toLowerCase();
            low.putIfAbsent(lowerCase, s);
            pat.putIfAbsent(f(lowerCase), s);
        }

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (set.contains(q)) {
                ans[i] = q;
                continue;
            }
            q = q.toLowerCase();
            if(low.containsKey(q)) {
                ans[i] = low.get(q);
                continue;
            }
            q = f(q);
            if(pat.containsKey(q)) {
                ans[i] = pat.get(q);
                continue;
            }
            ans[i] = "";
        }
        return ans;
    }

    private String f(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                charArray[i] = '*';
            }
        }
        return new String(charArray);
    }
}

