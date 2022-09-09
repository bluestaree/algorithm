package com.itheima.week8.trie_tree.trie208_0;

import org.junit.Test;

public class TrieTreeTest208 {
    @Test
    public void test208() {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true
        
    }
    
}
