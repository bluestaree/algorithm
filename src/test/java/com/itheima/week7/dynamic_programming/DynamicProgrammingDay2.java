package com.itheima.week7.dynamic_programming;

import org.junit.Test;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-20 09:55
 **/
public class DynamicProgrammingDay2 {
    @Test
    public void test1143最长公共子序列() {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
    
    /**
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        //初始值判断
        if (text1 == null || text2 == null) {
            return 0;
        }
        //状态参数
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        
        //dp数组
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        
        //初始值
        for (int i = 0; i < t1.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < t2.length; j++) {
            dp[0][j] = 0;
        }
        
        //状态转移逻辑        
        for (int i = 1; i <= t1.length; i++) {
            for (int j = 1; j <= t2.length; j++) {
                if (t1[i - 1] == t2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                // System.out.println("i: " + i + " j: " + j + " dp[i][j]: " + dp[i][j]);
            }
        }
        return dp[n][m];
    }
    
    @Test
    public void test712两个字符串的最小ASCII删除和() {
        // System.out.println(minDistance("sea", "eat"));
        System.out.println(minimumDeleteSum("delete", "leet"));
    }
    
    public int minimumDeleteSum(String s1, String s2) {
        //初始值判断
        if (s1 == null || s2 == null) {
            return 0;
        }
        int total2 = 0;
        int total1 = 0;
        char[] arr2 = s2.toCharArray();
        for (char c : arr2) {
            total2 += c;
        }
        char[] arr1 = s1.toCharArray();
        for (char c : arr1) {
            total1 += c;
        }
        //s1和s2都是有值的
        //动态规划
        int len1 = s1.length();
        int len2 = s2.length();
        //dp数组,存储相同的字符串数组最大ascii值
        int[][] dp = new int[len1 + 1][len2 + 1];
        //初始值为默认值0
        
        //进行特征方程循环
        for (int j = 1; j <= len2; j++) {
            for (int i = 1; i <= len1; i++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    //字符一样,说明需要增加
                    int max = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.max(max, dp[i - 1][j - 1] + arr1[i - 1]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //结束后,得到了最大的ascii值
        int sameMax = dp[len1][len2];
        return total1 - sameMax + total2 - sameMax;
    }
    
    @Test
    public void test583两个字符串的删除操作() {
        // System.out.println(minDistance("sea", "eat"));
        System.out.println(minDistance583("", "a"));
    }
    
    public int minDistance583(String word1, String word2) {
        //初始值判断
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null) {
            return word2.length();
        }
        if (word2 == null) {
            return word1.length();
        }
        //状态
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        
        //dp数组
        int n = w1.length;
        int m = w2.length;
        int[][] dp = new int[n + 1][m + 1];
        
        //初始值
        for (int i = 0; i <= w1.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= w2.length; j++) {
            dp[0][j] = j;
        }
        //状态转移方程
        for (int i = 1; i <= w1.length; i++) {
            for (int j = 1; j <= w2.length; j++) {
                if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
                System.out.println("i: " + i + " j: " + j + " dp[i][j]: " + dp[i][j]);
                
            }
        }
        //
        return dp[n][m];
    }
    
    public int minDistance72(String word1, String word2) {
        //初值不用判断
        if (word1 == null || word2 == null) {
            return 0;
        }
        
        //状态和选择
        char[] arr1 = word1.toCharArray();
        int len1 = word1.length();
        int len2 = word2.length();
        char[] arr2 = word2.toCharArray();
        
        //dp数组,存储操作步数
        int[][] dp = new int[len1 + 1][len2 + 1];
        //初始值
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        //状态转移
        for (int j = 1; j <= len2; j++) {
            for (int i = 1; i <= len1; i++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int min = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[len1][len2];
    }
    
    @Test
    public void test72编辑距离() {
        // System.out.println(minDistance(null, null));
        System.out.println(minDistance72("horse", "ros"));
        System.out.println(minDistance72("intention", "execution"));
    }
    
    public int minDistance(String word1, String word2) {
        //初始值判断
        //初始值判断
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null) {
            return word2.length();
        }
        if (word2 == null) {
            return word1.length();
        }
        
        //转态参数
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        
        //
        int n = w1.length;
        int m = w2.length;
        
        //dp数组
        int[][] dp = new int[n + 1][m + 1];
        
        //初始状态
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        
        //状态转移方程
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[n][m];
    }
    
    @Test
    public void test5最长回文子串() {
        
        // System.out.println(longestPalindrome("babad"));
        // System.out.println(longestPalindrome("cbbd"));
        // System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("aaaa"));
    }
    
    public String longestPalindrome(String s) {
        //初始值判断
        int len;
        if (s == null || (len = s.length()) == 0) {
            return s;
        }
        //动态规划
        //状态和选择
        char[] arr = s.toCharArray();
        
        //dp数组 
        boolean[][] dp = new boolean[len + 1][len + 1];
        
        //初始值
        for (int i = 0; i <= len; i++) {
            dp[i][i] = true;
        }
        
        int begin = 0;
        int maxLen = 1;
        //状态转移
        for (int j = 1; j <= len; j++) {
            for (int i = 1; i < j; i++) {
                if (arr[i - 1] == arr[j - 1]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    //记录最大的子序列长度和起始位置
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i - 1;
                    }
                }
            }
        }
        String sub = s.substring(begin, begin + maxLen);
        //
        return sub;
        
    }
    
    @Test
    public void test516最长回文子序列() {
        
        System.out.println(longestPalindromeSubseq("babad"));
        System.out.println(longestPalindromeSubseq("cbbd"));
        System.out.println(longestPalindromeSubseq("ac"));
        System.out.println(longestPalindromeSubseq("aaaa"));
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
    
    public int longestPalindromeSubseq(String s) {
        //初始值不需要判断了
        
        //选择和状态
        char[] arr = s.toCharArray();
        int len = s.length();
        
        //dp
        int[][] dp = new int[len][len];
        
        //初始值
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        //状态转移
        for (int j = 0; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    //错了,需要修正
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][len - 1];
    }
    
}
