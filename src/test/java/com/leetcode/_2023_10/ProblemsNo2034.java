package com.leetcode._2023_10;

import org.junit.Test;

import java.util.*;


/**
 * 2034. 股票价格波动
 *
 * @author DHW
 * @date 2023/10/8 9:22
 * @Version 1.0
 */
public class ProblemsNo2034 {

    @Test
    public void solution() {
        StockPrice obj = new StockPrice();
        obj.update(1, 2);
        System.out.println("current = " + obj.current());
        System.out.println("maximum = " + obj.maximum());
        System.out.println("minimum = " + obj.minimum());
    }

    class StockPrice {
        private Map<Integer, Integer> m;
        private TreeMap<Integer, Integer> d;
        private int curTime = 0;

        public StockPrice() {
            m = new HashMap<>();
            d = new TreeMap<>();
        }

        public void update(int timestamp, int price) {
            if(m.containsKey(timestamp)) {
                Integer old = m.get(timestamp);
                if(d.get(old) == 1) {
                    d.remove(old);
                }
            }
            curTime = Math.max(curTime, timestamp);
            d.put(price, d.getOrDefault(price, 0) + 1);
            m.put(timestamp, price);
        }

        public int current() {
            return m.get(curTime);
        }

        public int maximum() {
            return d.lastKey();
        }

        public int minimum() {
            return d.firstKey();
        }
    }
}