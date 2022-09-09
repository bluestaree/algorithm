package com.itheima.week8.union_find;

import org.junit.Test;

/**
 * @program: algo_pro
 * @description: 并查集 --省份数量
 * @author: zhanghz001
 * @create: 2021-10-05 17:22
 **/
public class UnionFind547 {
    @Test
    public void test547省份数量() {
        findCircleNum(null);
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind find = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    find.union(i, j);
                }
            }
        }
        return find.getCount();
    }
    
    static class UnionFind {
        int count;
        int[] father;
        
        public UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
            count = n;
        }
        
        public void union(int p, int q) {
            int q_root = find(q);
            int p_root = find(p);
            if (q_root != p_root) {
                father[p_root] = q_root;
                count--;
            }
        }
        
        public int find(int n) {
            //需要使用
            //结束条件
            if (father[n] == n) {
                return n;
            }
            //
            father[n] = find(father[n]);
            return father[n];
        }
        
        public int getCount() {
            return count;
        }
    }
}
