package com.itheima.week11.string_sort;

import org.junit.Test;

import java.util.HashMap;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-01-23 21:05
 **/
public class ComplexStringTest {
    @Test
    public void test10() {
        System.out.println(isMatch("aa", "a*"));
    }
    
    public boolean isMatch1(String s, String p) {
        //    
        char[] sarr = s.toCharArray();
        char[] parr = p.toCharArray();
        int i = 0;
        int j = 0;
        return isMatch(sarr, i, parr, j);
    }
    
    //递归
    private boolean isMatch(char[] s, int i, char[] p, int j) {
        int plen = p.length;
        //结束条件
        if (j == plen) {
            return i == s.length;
        }
        //当前层处理 
        boolean isMatch = i < s.length && (s[i] == p[j] || p[j] == '.');
        //不匹配
        if (j < (plen - 1) && p[j + 1] == '*') {
            //下一位是*  
            //匹配多次：当前这一位s[i]匹配一次，然后s的下一位继续这个模式匹配，j不变                
            return isMatch(s, i, p, j + 2) || (isMatch && isMatch(s, i + 1, p, j));
        }
        return isMatch && isMatch(s, i + 1, p, j + 1);
        
    }
    
    //动态规划
    public boolean isMatch(String s0, String p0) {
        //    
        char[] s = s0.toCharArray();
        char[] p = p0.toCharArray();
        int slen = s0.length();
        int plen = p0.length();
        //dp数组
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        //初始化状态
        dp[0][0] = true;
        for (int j = 0; j < plen; j++) {
            if (p[j] == '*') {
                dp[0][j + 1] = dp[0][j - 1] || dp[0][j];
            }
        }
        //状态遍历
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                if (s[i - 1] == p[j - 1] || p[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p[j - 1] == '*') {
                    if (p[j - 2] == s[i - 1] || p[j - 2] == '.') {
                        //多次匹配
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        //0次匹配
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[slen][plen];
    }
    
    @Test
    public void test115() {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }
    
    public int numDistinct1(String s0, String t0) {
        //不需要判断初始值
        int slen = s0.length();
        int tlen = t0.length();
        char[] s = s0.toCharArray();
        char[] t = t0.toCharArray();
        //dp数组
        int[][] dp = new int[slen + 1][tlen + 1];
        //初始值
        for (int i = 0; i <= slen; i++) {
            dp[i][0] = 1;
        }
        //状态转移方程
        for (int i = 1; i <= slen; i++) {
            for (int j = tlen; j >= 1; j--) {
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[slen][tlen];
    }
    
    public int numDistinct0(String s0, String t0) {
        //不需要判断初始值
        int slen = s0.length();
        int tlen = t0.length();
        char[] s = s0.toCharArray();
        char[] t = t0.toCharArray();
        //dp数组
        int[] dp = new int[tlen + 1];
        //初始值
        dp[0] = 1;
        //状态转移方程
        for (int i = 1; i <= slen; i++) {
            for (int j = tlen; j >= 1; j--) {
                if (s[i - 1] == t[j - 1]) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[tlen];
    }
    
    public int numDistinct(String s0, String t0) {
        //初始值判断
        //递归
        char[] s = s0.toCharArray();
        char[] t = t0.toCharArray();
        dps(s, 0, t, 0);
        return total;
    }
    
    int total = 0;
    HashMap<String, Integer> map = new HashMap<>();
    
    private void dps(char[] s, int i, char[] t, int j) {
        //terminal
        if (j == t.length) {
            total++;
            return;
        }
        if (i == s.length) {
            return;
        }
        //当前层处理
        int curr = total;
        String key = i + "_" + j;
        if (map.containsKey(key)) {
            total += map.get(key);
            return;
        }
        if (s[i] == t[j]) {
            dps(s, i + 1, t, j + 1);
        }
        dps(s, i + 1, t, j);
        //此次递归增加的数量
        map.put(key, total - curr);
    }
    
    @Test
    public void test28() {
        System.out.println(strStr("hello", "ll"));
    }
    
    public int strStr(String haystack, String needle) {
        //初始值判断
        if (needle == null || haystack == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        //
        char[] h = haystack.toCharArray();
        int hlen = h.length;
        char[] n = needle.toCharArray();
        int nlen = n.length;
        //
        int last = hlen - nlen + 1;
        for (int i = 0; i < last; i++) {
            if (h[i] == n[0]) {
                boolean isSubString = needle.equals(haystack.substring(i, i + nlen));
                if (isSubString) {
                    return i;
                }
            }
        }
        return -1;
    }
    
}
