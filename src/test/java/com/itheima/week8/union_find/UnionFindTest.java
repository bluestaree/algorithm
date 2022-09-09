package com.itheima.week8.union_find;

import org.junit.Test;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-27 19:54
 **/
public class UnionFindTest {
    @Test
    public void test547省份数量() {
        findCircleNum(null);
    }
    
    public int findCircleNum(int[][] M) {
        //    初始值
        if (M == null) {
            return 0;
        }
        //M的判断,
        int n = M.length;
        UnionFind set = new UnionFind(n);
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    set.union(i, j);
                }
            }
        }
        return set.getCount();
    }
    
    static class UnionFind {
        private int count;
        int[] father;
        
        public UnionFind(int count) {
            // num代表元素的个数,即初始时有num个单独的集合
            //初始条件每个元素的parent都指向自己
            father = new int[count];
            for (int i = 0; i < count; i++) {
                father[i] = i;
            }
            //初始集合个数即元素个数
            this.count = count;
        }
        
        /**
         * 查找
         *
         * @param n
         * @return
         */
        public int find(int n) {
            // while (father[n] != n) {
            //     n = father[n];
            // }
            //终止条件
            if (father[n] == n) {
                return n;
            }
            father[n] = find(father[n]);
            return father[n];
        }
        
        /**
         * 合并
         *
         * @param p
         * @param q
         */
        public void union(int p, int q) {
            int p_root = find(p);
            int q_root = find(q);
            if (p_root == q_root) {
                return;
            }
            father[q_root] = p_root;
            count--;
        }
        
        public int getCount() {
            return this.count;
        }
    }
    
}
