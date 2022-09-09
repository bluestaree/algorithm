package com.itheima.week8.trie_tree.trie208;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-10-05 10:06
 **/
public
//copy下面的
class Trie {
    TrieNode root = new TrieNode();
    
    public Trie() {
    }
    
    public void insert(String word) {
        TrieNode now = root;
        char[] apple = word.toCharArray();
        for (char c : apple) {
            TrieNode son = now.sons[c - 'a'];
            if (son == null) {
                son = new TrieNode();
                now.sons[c - 'a'] = son;
            }
            now = son;
        }
        now.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode now = root;
        
        char[] apple = word.toCharArray();
        for (char c : apple) {
            TrieNode son = now.sons[c - 'a'];
            if (son == null) {
                return false;
            }
            now = son;
        }
        return now != null && now.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode now = root;
        
        char[] apple = prefix.toCharArray();
        for (char c : apple) {
            TrieNode son = now.sons[c - 'a'];
            if (son == null) {
                return false;
            }
            now = son;
        }
        return now != null;
    }
    
    static class TrieNode {
        boolean isEnd = false;
        TrieNode[] sons = new TrieNode[26];
    }
    
}
