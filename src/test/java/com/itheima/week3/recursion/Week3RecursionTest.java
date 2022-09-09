package com.itheima.week3.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-09-16 09:22
 **/
public class Week3RecursionTest {
    @Test
    public void test剑指Offer10I斐波那契数列() {
        //递归
        System.out.println(fib(4));
    }
    
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        //定义两个数
        int first = 0;
        int second = 1;
        int temp;
        for (int i = 2; i <= n; i++) {
            temp = second;
            second = (second + first) % 1000000007;
            first = temp;
        }
        return second;
    }
    
    public int fib1(int n) {
        
        //结束条件
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        //下一层
        if (!map.containsKey(n - 1)) {
            map.put(n - 1, fib(n - 1));
        }
        if (!map.containsKey(n - 2)) {
            map.put(n - 2, fib(n - 2));
        }
        //当前层
        return (map.get(n - 1) + map.get(n - 2)) % 1000000007;
        
        //后续处理
    }
    
    @Test
    public void test70爬楼梯() {
        //递归
        System.out.println(climbStairs(4));
    }
    
    HashMap<Integer, Integer> map70 = new HashMap<>();
    
    public int climbStairs(int n) {
        //结束条件
        if (n <= 2) {
            map70.put(n, n);
            return n;
        }
        
        //终止条件
        if (map70.containsKey(n)) {
            return map70.get(n);
        }
        //上一层
        int n1 = climbStairs(n - 1);
        map70.put(n - 1, n1);
        int n2 = climbStairs(n - 2);
        map70.put(n - 2, n2);
        
        //当前层
        int n3 = n1 + n2;
        map70.put(n, n3);
        
        //返回
        return n3;
    }
    
    public int climbStairs1(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fibn / sqrt5);
    }
    
    @Test
    public void test22括号生成() {
        List<String> list = generateParenthesis(4);
        
        //递归
        System.out.println(list);
        System.out.println("===============");
        String[] sarr = new String[]{"(((())))", "((()()))",
                "((())())", "((()))()", "(()(()))",
                "(()()())", "(()())()", "(())(())",
                "(())()()", "()((()))", "()(()())",
                "()(())()", "()()(())", "()()()()"};
        for (String s : sarr) {
            if (!list.contains(s)) {
                //有输出说明就不对
                System.out.println(s);
            }
        }
    }
    
    public List<String> generateParenthesis(int n) {
        //初始值判断
        if (n <= 0) {
            return Collections.emptyList();
        }
        // 复习的时候做,使用递归做哦 
        return new ArrayList<>();
    }
    
}
