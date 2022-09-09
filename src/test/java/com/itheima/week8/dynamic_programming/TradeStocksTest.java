package com.itheima.week8.dynamic_programming;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-24 14:38
 **/
public class TradeStocksTest {
    
    @Test
    public void test121买卖股票的最佳时机() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        // int[] prices = {7, 6, 4, 3, 1};
        System.out.println(maxProfit121_2(prices));
    }
    
    public int maxProfit121(int[] prices) {
        //    初始值判断
        if (prices == null) {
            return 0;
        }
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        //    状态 
        //dp数组 第i天,第k次交易,是否持有股票
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        //初始值 
        //状态转移
        for (int i = 1; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        //返回
        return dp_i_0;
    }
    
    public int maxProfit121_2(int[] prices) {
        //初始值判断
        int n = prices.length;
        //dp数组
        int[][] dp = new int[n][2];
        
        //初始值
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        //状态转移
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
    
    @Test
    public void test122买卖股票的最佳时机II() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        // int[] prices = {1, 2, 3, 4, 5};
        // int[] prices = {7, 6, 4, 3, 1};
        System.out.println(maxProfit122_2(prices));
    }
    
    //n次交易
    public int maxProfit122(int[] prices) {
        //    初始值判断
        if (prices == null) {
            return 0;
        }
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        //    状态
        
        //dp数组 第i天是否持有股票
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        //初始值 
        
        //状态转移
        for (int i = 1; i < n; i++) {
            int temp = dp_i_1;
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
            dp_i_0 = Math.max(dp_i_0, temp + prices[i]);
        }
        //返回
        return dp_i_0;
    }
    
    //n次交易
    public int maxProfit122_2(int[] prices) {
        //
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        
        //状态转移
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
    
    @Test
    public void test309最佳买卖股票时机含冷冻期() {
        // int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {1, 2, 3, 0, 2};
        // int[] prices = {1, 2, 3, 4, 5};
        // int[] prices = {7, 6, 4, 3, 1};
        System.out.println(maxProfit309(prices));
    }
    
    //n次交易
    public int maxProfit309(int[] prices) {
        //    初始值判断
        if (prices == null) {
            return 0;
        }
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        //    状态
        
        //dp数组 第i天是否持有股票
        int dp_i_2 = 0;
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        //初始值
        
        //状态转移
        for (int i = 1; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_i_2 - prices[i]);
            dp_i_2 = temp;
        }
        //返回
        return dp_i_0;
    }
    
    @Test
    public void test714买卖股票的最佳时机含手续费() {
        // int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {1, 3, 2, 8, 4, 9};
        // int[] prices = {1, 2, 3, 4, 5};
        // int[] prices = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices, 2));
    }
    
    //含手续费
    public int maxProfit(int[] prices, int fee) {
        //    初始值判断
        if (prices == null) {
            return 0;
        }
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        //    状态
        
        //dp数组 第i天是否持有股票
        int dp_i_0 = 0;
        // int dp_i_1 = -prices[0] - fee;
        int dp_i_1 = Integer.MIN_VALUE + fee;
        //初始值 
        
        //状态转移
        for (int price : prices) {
            int temp = dp_i_1;
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - price - fee);
            dp_i_0 = Math.max(dp_i_0, temp + price);
        }
        //返回
        return dp_i_0;
    }
    
    @Test
    public void test123买卖股票的最佳时机III() {
        // int[] prices = {1, 2, 3, 4, 5};
        int[] prices = {7, 6, 4, 3, 1};
        // int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }
    
    //最多k次
    public int maxProfit(int[] prices) {
        //    初始值判断
        if (prices == null) {
            return 0;
        }
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        //    状态
        int dp_i_1_0 = 0;
        int dp_i_1_1 = Integer.MIN_VALUE;
        int dp_i_2_0 = 0;
        int dp_i_2_1 = Integer.MIN_VALUE;
        
        //dp数组 第i天,第k次交易,是否持有股票 
        //初始值
        //状态转移
        for (int price : prices) {
            
            dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + price);
            dp_i_2_1 = Math.max(dp_i_2_1, dp_i_1_0 - price);
            
            dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + price);
            dp_i_1_1 = Math.max(dp_i_1_1, -price);
            
        }
        //返回 
        return dp_i_2_0;
    }
    
    @Test
    public void test188买卖股票的最佳时机IV() {
        // int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {3, 2, 6, 5, 0, 3};
        // int[] prices = {1, 2, 3, 4, 5};
        // int[] prices = {7, 6, 4, 3, 1};
        System.out.println(maxProfit188(2, prices));
    }
    
    public int maxProfit188(int K, int[] prices) {
        //初始值判断
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        if (K <= 0) {
            return 0;
        }
        //其他值
        K = Math.min(n / 2, K) + 1;
        
        //dp数组
        int[][][] dp = new int[n][K][2];
        
        for (int i = 0; i < n; i++) {
            for (int k = 1; k < K; k++) {
                if (i == 0) {
                    dp[0][k][0] = 0;
                    dp[0][k][1] = -prices[0];
                } else {
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
            }
        }
        return dp[n - 1][K - 1][0];
    }
    
    public int maxProfit(int K, int[] prices) {
        if (prices == null) {
            return 0;
        }
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        //    状态
        K = Math.min(K, n / 2) + 1;
        //dp数组 第i天,第k次交易,是否持有股票
        int[][][] dp = new int[n][K][2];
        //初始值
        //状态转移
        for (int i = 0; i < n; i++) {
            for (int k = 1; k < K; k++) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[0];
                } else {
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        //返回 
        return dp[n - 1][K - 1][0];
    }
    
    @Test
    public void test53最大子序和() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
    
    public int maxSubArray(int[] nums) {
        //进行动态规划
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (dp > 0) {
                dp = dp + num;
            } else {
                dp = num;
            }
            max = Math.max(max, dp);
        }
        return max;
    }
    
    @Test
    public void test152乘积最大子数组() {
        // int[] nums = {2, 3, -2, 4};
        int[] nums = {2, -5, -2, -4, 3};
        // int[] nums = {2, 3, -2, 4, -5, 3};
        System.out.println(maxProduct(nums));
    }
    
    public int maxProduct(int[] nums) {
        //初始值判断
        int n;
        if (nums == null || (n = nums.length) == 0) {
            return 0;
        }
        //其他情况
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        dp[0] = nums[0];
        dp2[0] = nums[0];
        int max = dp[0];
        
        for (int i = 1; i < n; i++) {
            int dp_i_1 = dp[i - 1] * nums[i];
            int dp2_i_1 = dp2[i - 1] * nums[i];
            dp[i] = Math.max(Math.max(dp2_i_1, dp_i_1), nums[i]);
            
            dp2[i] = Math.min(Math.min(dp2_i_1, dp_i_1), nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
    
    @Test
    public void test120三角形最小路径和() {
        System.out.println(minimumTotal(null));
    }
    
    HashMap<String, Integer> map = new HashMap<>();
    int size;
    
    public int minimumTotal(List<List<Integer>> triangle) {
        size = triangle.size();
        //需要进行递归,采用dfs+map缓存
        int level = 0;
        int nowIdx = 0;
        return dfs(triangle, level, nowIdx);
    }
    
    private int dfs(List<List<Integer>> triangle, int level, int nowIdx) {
        String key = level + "_" + nowIdx;
        //终止条件
        if (level == size) {
            map.put(key, 0);
            return 0;
        }
        //当前层处理
        
        //左边
        String leftKey = (level + 1) + "_" + nowIdx;
        int left;
        if (map.containsKey(leftKey)) {
            left = map.get(leftKey);
        } else {
            left = dfs(triangle, level + 1, nowIdx);
        }
        
        //右边
        String rightKey = (level + 1) + "_" + (nowIdx + 1);
        int right;
        if (map.containsKey(rightKey)) {
            right = map.get(rightKey);
        } else {
            right = dfs(triangle, level + 1, nowIdx + 1);
        }
        
        //当前
        
        List<Integer> list = triangle.get(level);
        Integer now = list.get(nowIdx);
        int total = now + Math.min(left, right);
        map.put(key, total);
        return total;
    }
    
    @Test
    public void test44通配符匹配() {
        String s;
        String p;
        // s = "acdcb";
        // p = "a*c?b";
        s = "adceb";
        p = "*a*b";
        System.out.println(isMatch(s, p));
    }
    
    public boolean isMatch(String str, String pStr) {
        //
        if (str == null && pStr == null) {
            return true;
        }
        if (str == null || pStr == null) {
            return false;
        }
        //需要动态规划
        int n = str.length();
        int m = pStr.length();
        //dp数组
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        //初始值
        dp[0][0] = true;
        char[] p = pStr.toCharArray();
        char[] s = str.toCharArray();
        for (int j = 1; j <= m; j++) {
            if (p[j - 1] == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                break;
            }
        }
        
        //需要状态转移
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s[i - 1] == p[j - 1] || p[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}
