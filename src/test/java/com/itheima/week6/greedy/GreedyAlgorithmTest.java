package com.itheima.week6.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-13 07:38
 **/
public class GreedyAlgorithmTest {
    @Test
    public void test322零钱兑换() {
        // int amount = 11;
        // int[] coins = {1, 2, 5};
        int amount = 9864;
        int[] coins = {411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422};
        System.out.println(coinChange(coins, amount));
    }
    
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }
        //排序
        sort(coins);
        
        //贪心,
        int level = 0;
        int count = 0;
        dfs32(coins, amount, level, count);
        if (min3220 == Integer.MAX_VALUE) {
            return -1;
        }
        return min3220;
    }
    
    private void dfs32(int[] coins, int rest, int level, int count) {
        //终止条件        
        if (rest == 0) {
            //把最小值赋值
            if (count < min3220) {
                min3220 = count;
            }
            return;
        }
        if (level >= coins.length) {
            return;
        }
        //需要进行当前层处理
        int maxCount = rest / coins[level];
        for (int i = maxCount; i >= 0; i--) {
            //肯定大的就不要往下了
            if (count + i >= min3220) {
                continue;
            }
            dfs32(coins, rest - coins[level] * i,
                    level + 1, count + i);
            
        }
    }
    
    int min3220 = Integer.MAX_VALUE;
    
    private void sort(int[] coins) {
        Arrays.sort(coins);
        int n = coins.length - 1;
        for (int i = 0; i <= (n - 1) / 2; i++) {
            int tmp = coins[i];
            coins[i] = coins[n - i];
            coins[n - i] = tmp;
        }
    }
    
    @Test
    public void test455分发饼干() {
        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};
        System.out.println(findContentChildren(g, s));
    }
    
    public int findContentChildren(int[] g, int[] s) {
        //初始值判断
        if (s == null || s.length == 0) {
            return 0;
        }
        //排序
        Arrays.sort(g);
        Arrays.sort(s);
        
        //循环 
        int j = 0;
        int count = 0;
        int i = 0;
        while (j < s.length && i < g.length) {
            if (s[j] >= g[i]) {
                count++;
                j++;
                i++;
            } else {
                j++;
            }
        }
        return count;
    }
    
    @Test
    public void test122买卖股票的最佳时机II() {
        // int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }
    
    public int maxProfit(int[] prices) {
        //   初始值判断
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int sum = 0;
        int buyId = -1;
        //其他情况
        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }
    
    @Test
    public void test55跳跃游戏() {
        // int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }
    
    public boolean canJump(int[] nums) {
        //初始值判断
        if (nums == null || nums.length == 0) {
            return false;
        }
        //递归,使用贪心快点到终点
        int level = 0;
        return dfs55(nums, level);
        
    }
    
    private boolean dfs55(int[] nums, int level) {
        //终止条件
        if (level == nums.length - 1) {
            return true;
        }
        //需要使用
        int max = nums[level];
        for (int i = max; i > 0; i--) {
            
            boolean b = dfs55(nums, level + i);
            if (b) {
                return true;
            }
            
        }
        //
        return false;
    }
    
    public boolean canJump1(int[] nums) {
        //    初始值判断
        if (nums == null) {
            return true;
        }
        int len = nums.length;
        if (len == 0) {
            return true;
        }
        
        int farest = 0;
        for (int i = 0; i < nums.length; i++) {
            // System.out.println("i:" + i + " farest:  " + farest);
            if (i > farest) {
                return false;
            }
            int num = nums[i] + i;
            if (num > farest) {
                farest = num;
            }
        }
        return true;
    }
    
    @Test
    public void test45跳跃游戏II() {
        // int[] nums = {2, 3, 1, 1, 4};
        // int[] nums = {2, 3, 0, 1, 4};
        int[] nums = {8,
                2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5,
                1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7, 6, 5, 1,
                7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2,
                0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7,
                0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5};
        System.out.println(jump(nums));
    }
    
    public int jump(int[] nums) {
        //初始值不要判断了
        int level = 0;
        int count = 0;
        
        dfs45(nums, level, count);
        //总是可以到达最后,所以直接返回
        return min455;
    }
    
    int min455 = Integer.MAX_VALUE;
    
    private void dfs45(int[] nums, int level, int count) {
        //剪枝
        if (count >= min455) {
            return;
        }
        //终止条件
        if (level >= nums.length - 1) {
            min455 = Math.min(min455, count);
            return;
        }
        //需要递归
        int max = nums[level];
        for (int i = max; i > 0; i--) {
            dfs45(nums, level + i, count + 1);
        }
    }
    
    public int jump2(int[] nums) {
        //   边界位置
        int boundary = 0;
        // 最远位置
        int maxPoint = 0;
        //步数
        int stepCount = 0;
        //在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于
        // 等于最后一个位置，
        // 否则就无法跳到最后一个位置了。
        // 如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次
        // 数」
        for (int i = 0; i < nums.length - 1; i++) {
            //    找到最远位置
            maxPoint = Math.max(maxPoint, i + nums[i]);
            //i走到边界后,更新边界并增加跳跃次数
            if (i == boundary) {
                boundary = maxPoint;
                stepCount++;
            }
            
        }
        return stepCount;
    }
    
    public int jump1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        len45 = nums.length;
        if (len45 == 0) {
            return 0;
        }
        //开始递归,回溯,贪心合一 
        int level = 0;
        int count = 0;
        dfsJump(nums, level, count);
        return min45;
    }
    
    private void dfsJump(int[] nums, int level, int count) {
        //terminal        
        if (count >= min45) {
            return;
        }
        if (len45 - 1 <= level) {
            min45 = count;
            return;
        }
        int num = nums[level];
        if (num == 0) {
            return;
        }
        //当期层处理
        for (int i = num; i > 0; i--) {
            //下一层
            int level0 = i + level;
            dfsJump(nums, level0, count + 1);
        }
    }
    
    int len45;
    int min45 = Integer.MAX_VALUE;
    
    @Test
    public void test860柠檬水找零() {
        int[] bills = {5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
        System.out.println(lemonadeChange(bills));
    }
    
    public boolean lemonadeChange(int[] bills) {
        //初值不需要判断
        //零钱张数
        int[] changes = new int[11];
        for (int val : bills) {
            switch (val) {
                case 5:
                    changes[5]++;
                    break;
                case 10:
                    if (changes[5] >= 1) {
                        changes[5]--;
                        changes[10]++;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if (changes[5] >= 1 && changes[10] >= 1) {
                        changes[5]--;
                        changes[10]--;
                    } else if (changes[5] >= 3) {
                        changes[5] -= 3;
                    } else {
                        return false;
                    }
                    break;
                default:
                
            }
        }
        return true;
    }
    
}
