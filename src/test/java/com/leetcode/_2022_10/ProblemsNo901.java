package com.leetcode._2022_10;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


/**
 * 901. 股票价格跨度
 *
 * @author DHW
 * @date 2022/10/21 14:05
 * @Version 1.0
*/
public class ProblemsNo901 {

    @Test
    public void solution() {
        StockSpanner spanner = new StockSpanner();

        System.out.println("arr = " + spanner.next(100));
        System.out.println("arr = " + spanner.next(80));
        System.out.println("arr = " + spanner.next(60));
        System.out.println("arr = " + spanner.next(70));
        System.out.println("arr = " + spanner.next(60));
        System.out.println("arr = " + spanner.next(75));
        System.out.println("arr = " + spanner.next(85));
    }

    class StockSpanner {
        Deque<Stock> deque;

        public StockSpanner() {
            deque = new ArrayDeque();
        }

        public int next(int price) {
            int day = 1;
            while (!deque.isEmpty() && deque.peekLast().price <= price)
                day += deque.removeLast().day;
            deque.addLast(new Stock(price, day));
            return day;
        }

        class Stock {
            public int price;
            public int day;

            public Stock(int price, int day) {
                this.price = price;
                this.day = day;
            }
        }
    }
}