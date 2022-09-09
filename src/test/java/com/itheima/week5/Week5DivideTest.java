package com.itheima.week5;

import org.junit.Test;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-06 13:58
 **/
public class Week5DivideTest {
    @Test
    public void test50Pow() {
        int n = -2147483648;
        System.out.println(myPow(2, n));
    }
    
    public double myPow(double x, int n) {
        //初始值判断
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        //递归进行操作,采用分治
        if (n < 0) {
            double v = recursion50(x, -n);
            return 1 / v;
        } else {
            double v = recursion50(x, n);
            return v;
        }
    }
    
    private double recursion50(double x, int n) {
        //终止条件
        if (n == 1) {
            return x;
        } else if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
        }
        if (n % 2 == 1) {
            double v = recursion50(x, n / 2);
            return v * v * x;
        } else {
            double v = recursion50(x, n / 2);
            return v * v;
            
        }
    }
    
    @Test
    public void test69x的平方根() {
        System.out.println(mySqrt(2147395599));
    }
    
    public int mySqrt(int y) {
        //初始值判断
        if (y == 1) {
            return y;
        }
        //其他情况
        long min = 0;
        long max = y >>> 1;
        long mid;
        while (min <= max) {
            mid = (max + min) / 2;
            long pow2 = mid * mid;
            if (pow2 == y) {
                return (int) mid;
            } else if (pow2 > y) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return (int) max;
    }
    
    public int mySqrt1(int x) {
        //初始值判断
        if (x <= 1) {
            return x;
        }
        //
        long l = 1;
        long r = x >>> 1;
        while (l <= r) {
            long mid = (l + r) >>> 1;
            long s = mid * mid;
            // System.out.println("left: " + l + " right: " + r + " mid: " + mid + " s: " + s);
            if (s > x) {
                r = mid - 1;
            } else if (s < x) {
                l = mid + 1;
            } else {
                return (int) mid;
            }
        }
        return (int) r;
    }
}
