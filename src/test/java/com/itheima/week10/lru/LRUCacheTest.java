package com.itheima.week10.lru;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-01-17 17:55
 **/
public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
