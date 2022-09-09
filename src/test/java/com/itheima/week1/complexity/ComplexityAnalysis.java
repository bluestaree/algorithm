package com.itheima.week1.complexity;

import org.junit.Test;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-17 09:46
 **/
public class ComplexityAnalysis {
    @Test
    public void test1() {
        System.out.println(sum(100));
    }
    
    /**
     * 求1~n的累加和
     *
     * @param n
     * @return
     */
    public int sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }
    
    public int sum2(int n) {
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                sum = sum + i * j;
            }
        }
        return sum;
    }
    
    public int sum3(int n) {
        int sum_1 = 0;
        int p = 1;
        //100
        for (; p <= 100; ++p) {
            sum_1 = sum_1 + p;
        }
        int sum_2 = 0;
        int q = 1;
        for (; q < n; ++q) {
            sum_2 = sum_2 + q;
        }
        //O(n)
        int sum_3 = 0;
        int i = 1;
        int j = 1;
        for (; i <= n; ++i) {
            j = 1;
            for (; j <= n; ++j) {
                sum_3 = sum_3 + i * j;
            }
        }
        //O(n ^ 2)
        return sum_1 + sum_2 + sum_3;
    }
    
    public int maxArea1(int[] height) {
        int space = 0;
        int len = height.length;
        for (int i = 0; i < len; i++) {
            int ai = height[i];
            for (int j = i + 1; j < len; j++) {
                int aj = height[j];
                int nowSpace = Math.min(ai, aj) * (j - i);
                if (space < nowSpace) {
                    space = nowSpace;
                }
            }
        }
        return space;
    }
    
    public int sum4(int[] nArr, int[] mArr) {
        int sum = 0;
        for (int i : nArr) {
            sum += i;
        } //O(M)
        for (int i : mArr) {
            sum += i;
        } //O(N)
        return sum;
    }
    
    public void test02(int n) {
        int i = 0;
        int sum = 0;
        for (; i < 100; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
    }
    
    public void test04(int n) {
        int i = 1;
        while (i < n) {
            i = i * 2;
        }
    }
    
    public void test05(int n) {
        int i = 1;
        for (int i1 = 0; i1 < n; i1++) {
            while (i < n) {
                i = (i * 2);
            }
        }
    }
}
