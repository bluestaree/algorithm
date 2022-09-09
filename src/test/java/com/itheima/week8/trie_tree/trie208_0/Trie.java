package com.itheima.week8.trie_tree.trie208_0;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-27 10:08
 **/

class Trie {
    static class TrieNode {
        private final static int R = 26;
        private boolean isEnd = false;
        TrieNode[] links = new TrieNode[R];
        
        public TrieNode() {
            
        }
        
        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }
        
        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }
        
        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }
        
        public void setEnd() {
            this.isEnd = true;
        }
        
        public boolean isEnd() {
            return isEnd;
        }
    }
    
    TrieNode root = new TrieNode();
    
    /**
     * Initialize your data structure here.
     */
    public Trie() {
    }
    
    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }
    
    public TrieNode searchPrefix(String word) {
        if (word == null || word.length() == 0) {
            return null;
        }
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return null;
            }
        }
        return node;
    }
    
    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        if (node == null) {
            return false;
        } else {
            return node.isEnd();
        }
    }
    
    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        
        return node != null;
    }
}

