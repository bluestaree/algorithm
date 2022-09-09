package com.itheima.week8.trie_tree.trie208;

import org.junit.Test;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-10-05 10:05
 **/
public class TrieTest {
    @Test
    public void test208实现Trie() {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean apple = trie.search("apple");// 返回 True
        System.out.println(apple);
        boolean app = trie.search("app");// 返回 False
        System.out.println(app);
        boolean app1 = trie.startsWith("app");// 返回 True
        System.out.println(app1);
        trie.insert("app");
        boolean app2 = trie.search("app");// 返回 True
        System.out.println(app2);
        
    }
}
