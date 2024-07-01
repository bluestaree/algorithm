package com.leetcode._2024_6;

import cn.hutool.core.date.format.FastDatePrinter;
import org.junit.Test;

import java.util.Arrays;


/**
 * 522. 最长特殊序列 II
 *
 * @author DHW
 * @date 2024/6/17 9:23
 * @Version 1.0
*/
public class ProblemsNo522 {

    @Test
    public void solution() {
        String[] strs = new String[]{"a","b","c","d","e","f","a","b","c","d","e","f","g"};
        System.out.println("res = " + findLUSlength(strs));
    }

    public int findLUSlength(String[] strs) {
        int res = -1;
        Arrays.sort(strs, (a,b) -> {
            if(a.length() == b.length()) {
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });
        for (int i = 0; i < strs.length; i++) {
            if(strs[i] == "") {
                continue;
            }
            if(i+1 == strs.length) {
                return strs[i].length();
            }
            boolean flag = false;
            for (int j = i + 1; j < strs.length; j++) {
                if(flag && !strs[i].equals(strs[j])) {
                    break;
                }
                if(strs[i].equals(strs[j])) {
                    strs[j] = "";
                    flag = true;
                }
                if(!flag && isSubChar(strs[i], strs[j])) {
                    flag = true;
                }
            }
            if(!flag) {
                res = strs[i].length();
            }
        }
        return res;
    }

    private boolean isSubChar(String a, String b) {
        int m = a.length();
        int n = b.length();
        int i = 0;
        for (int j = 0; j < n && i < m; j++) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
        }
        return i == m;
    }
}

