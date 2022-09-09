package com.itheima.week7.dynamic_programming;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-16 11:12
 **/
public class DynamicProgrammingDay1 {
    
    int[] arr322;
    
    public int coinChange1(int[] coins, int amount) {
        //
        Arrays.sort(coins);
        arr322 = new int[amount + 1];
        Arrays.fill(arr322, -2);
        arr322[0] = 1;
        return dfs322(coins, amount);
    }
    
    /**
     * 递归+缓存
     *
     * @param coins
     * @param amount
     * @return
     */
    private int dfs322(int[] coins, int amount) {
        //终止条件
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        //使用缓存,避免重复计算
        if (arr322[amount] != -2) {
            return arr322[amount];
        }
        
        int count = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            //选择 
            int last = amount - coins[i];
            if (last < 0) {
                continue;
            }
            
            //下一层
            int count1 = dfs322(coins, last);
            arr322[last] = count1;
            if (count1 != -1) {
                count = Math.min(count, count1 + 1);
            }
            
            //撤回
        }
        if (count == Integer.MAX_VALUE) {
            return -1;
        }
        
        //
        return count;
    }
    
    @Test
    public void test322零钱兑换() {
        // int amount = 11;
        // int[] coins = {1, 2, 5};
        // int amount = 18;
        // int[] coins = {1, 9, 10};
        int amount = 3;
        int[] coins = {2};
        System.out.println(coinChange(coins, amount));
    }
    
    /**
     * 动态规划
     * 1:状态转移方程
     * 2:df数组
     * 3:初始状态
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        //初值判断
        // Arrays.sort(coins);
        //动态规划
        //df数组
        int[] dp = new int[amount + 1];
        //填充的值,如果是Integer.MAX,会导致后面+1后变成负数,不能这样赋值
        Arrays.fill(dp, amount + 1);
        
        //初始值
        dp[0] = 0;
        
        //需要进行递归+状态转移方程
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    //才会记录
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }
    
    @Test
    public void test300最长上升子序列() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
    
    public int lengthOfLIS(int[] nums) {
        //初始值判断
        if (nums.length == 1) {
            return 1;
        }
        //dp数组和初始化
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        //找到最大值
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
        
    }
}
