package com.itheima.week7.dynamic_programming;

import com.itheima.week4.binary_tree.TreeNode;
import org.junit.Test;

import java.util.HashMap;

/**
 * @program: algo_pro
 * @description: 动态规划
 * @author: zhanghz001
 * @create: 2021-09-30 12:06
 **/
public class DynamicProgrammingDay3 {
    
    @Test
    public void test1049最后一块石头的重量II() {
        // int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        int[] stones = new int[]{31, 26, 33, 21, 40};
        System.out.println(lastStoneWeightII(stones));
    }
    
    public int lastStoneWeightII(int[] stones) {
        //初始值不需要判断了
        
        //状态和选择
        int weight = 0;
        for (int stone : stones) {
            weight += stone;
        }
        int w = weight / 2;
        int len = stones.length;
        //dp数组
        boolean[][] dp = new boolean[len + 1][w + 1];
        
        //初始值
        dp[0][0] = true;
        
        //状态转移           
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= w; j++) {
                //
                if (j >= stones[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int j = w; j >= 0; j--) {
            if (dp[len][j]) {
                return weight - 2 * j;
            }
        }
        //异常情况
        return weight;
    }
    
    @Test
    public void testBackPack() {
        
        int N = 3, W = 5; // 物品的总数，背包能容纳的总重量
        int[] w = {3, 2, 1}; // 物品的重量
        int[] v = {5, 2, 3}; // 物品的价值
        System.out.println(dp(w, v, N, W));
    }
    
    public int dp(int[] wt, int[] v, int N, int W) {
        //    初始值判断 忽略  x
        //状态
        
        //dp数组
        int[][] dp = new int[N + 1][W + 1];
        //初始状态
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= W; j++) {
            dp[0][j] = 0;
        }
        //状态转移
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j < wt[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + v[i - 1]);
                }
            }
        }
        //返回
        return dp[N][W];
    }
    
    @Test
    public void test494目标和() {
        
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums, 3));
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        //初始值判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum - target) % 2 != 0 || (sum - target) < 0) {
            return 0;
        }
        
        //选择和状态
        int neg = (sum - target) / 2;
        
        //初始值,dp
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        
        //状态转移
        int len = nums.length;
        for (int i = 1; i <= len; i++) {
            for (int j = neg; j >= nums[i - 1]; j--) {
                dp[j] = (dp[j] + dp[j - nums[i - 1]]);
            }
        }
        // 返回
        return dp[neg];
    }
    
    @Test
    public void test416分割等和子集() {
        
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
    
    /**
     * dp数组压缩的分割和子集问题
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        //初始值判断
        if (nums == null) {
            return false;
        }
        
        int N = nums.length;
        if (N == 0) {
            return true;
        }
        //剪枝
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        //不是偶数,不能对半分
        if (sum % 2 != 0) {
            return false;
        }
        int W = sum / 2;
        //最大值大于一半
        if (max > W) {
            return false;
        }
        //状态
        //dp数组
        boolean[] dp = new boolean[W + 1];
        
        //初始状态 默认就是
        dp[0] = true;
        //状态转移
        
        for (int i = 1; i <= N; i++) {
            for (int j = W; j >= 0; j--) {
                if (nums[i - 1] <= j) {
                    // System.out.println("i: " + i + " j: " + j + " nums[] " + nums[i - 1]);
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }
        //返回
        return dp[W];
    }
    
    /**
     * dp数组不压缩的分割和子集问题
     *
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums) {
        //初始值判断
        if (nums == null) {
            return false;
        }
        
        int N = nums.length;
        if (N == 0) {
            return true;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        //不是偶数,不能对半分
        if (sum % 2 != 0) {
            return false;
        }
        int W = sum / 2;
        //最大值大于一半
        if (max > W) {
            return false;
        }
        //状态
        //dp数组
        boolean[][] dp = new boolean[N + 1][W + 1];
        
        //初始状态 默认就是
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }
        //状态转移
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // System.out.println("i: " + i + " j: " + j + " nums[] " + nums[i - 1]);
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        //返回
        return dp[N][W];
    }
    
    @Test
    public void test518零钱兑换II() {
        
        int[] nums = {1, 2, 5};
        System.out.println(change(5, nums));
    }
    
    public int change(int amount, int[] coins) {
        //    初始值判断
        if (coins == null) {
            return 0;
        }
        int N = coins.length;
        //状态
        
        //dp函数
        int[] dp = new int[amount + 1];
        //初始值
        dp[0] = 1;
        //状态转移
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1]) {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }
        //返回
        return dp[amount];
    }
    
    public int change1(int amount, int[] coins) {
        //    初始值判断
        if (coins == null) {
            return 0;
        }
        int N = coins.length;
        //状态
        
        //dp函数
        int[][] dp = new int[N + 1][amount + 1];
        //初始值
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        //状态转移
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        //返回
        return dp[N][amount];
    }
    
    @Test
    public void test198打家劫舍() {
        
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob2(nums));
    }
    
    public int rob2(int[] nums) {
        //    初始判断
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        //状态
        //dp数组
        // int[] dp = new int[n + 2];
        //初始值
        // dp[n] = 0;
        // dp[n + 1] = 0;
        int dp_i = 0;
        int dp_i_1 = 0;
        int dp_i_2 = 0;
        //状态转移
        for (int i = n - 1; i >= 0; i--) {
            dp_i = Math.max(dp_i_1, dp_i_2 + nums[i]);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
            // System.out.println("i : " + i + " : dp[] " + dp[i]);
        }
        //返回
        return dp_i;
    }
    
    public int rob1(int[] nums) {
        //    初始判断
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        //状态
        //dp数组
        int[] dp = new int[n + 2];
        //初始值
        dp[n] = 0;
        dp[n + 1] = 0;
        //状态转移
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
            // System.out.println("i : " + i + " : dp[] " + dp[i]);
        }
        //返回
        return dp[0];
    }
    
    @Test
    public void test213打家劫舍II() {
        int[] nums = {1, 2, 3, 1};
        // int[] nums = {2, 3, 2};
        System.out.println(rob(nums));
    }
    
    public int rob(int[] nums) {
        //初始值判断
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        //先去尾进行递归,得到dp[0]
        int dp_i = 0;
        int dp_i_1 = 0;
        int dp_i_2 = 0;
        
        for (int i = len - 2; i >= 0; i--) {
            dp_i = Math.max(dp_i_1, dp_i_2 + nums[i]);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        int max1 = dp_i;
        
        //去头再进行递归 
        dp_i_1 = 0;
        dp_i_2 = 0;
        for (int i = len - 1; i > 0; i--) {
            dp_i = Math.max(dp_i_1, dp_i_2 + nums[i]);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        int max2 = dp_i;
        return Math.max(max1, max2);
    }
    
    @Test
    public void test337打家劫舍III() {
        TreeNode node = new TreeNode();
        System.out.println(rob(node));
    }
    
    HashMap<TreeNode, Integer> contain = new HashMap<>();
    HashMap<TreeNode, Integer> notContain = new HashMap<>();
    
    public int rob(TreeNode now) {
        //null判断
        if (now == null) {
            return 0;
        }
        
        //dfs递归
        contain.put(null, 0);
        notContain.put(null, 0);
        
        dfs337(now);
        return Math.max(contain.get(now), notContain.get(now));
    }
    
    private void dfs337(TreeNode now) {
        //终止条件
        if (now == null) {
            return;
        }
        //当前层处理
        dfs337(now.left);
        dfs337(now.right);
        int val = now.val;
        contain.put(now, val + notContain.get(now.left) + notContain.get(now.right));
        notContain.put(now,
                Math.max(contain.get(now.left), notContain.get(now.left))
                        + Math.max(contain.get(now.right), notContain.get(now.right)));
    }
}
