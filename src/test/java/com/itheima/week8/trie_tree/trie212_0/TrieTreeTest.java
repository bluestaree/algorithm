package com.itheima.week8.trie_tree.trie212_0;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-27 14:29
 **/
public class TrieTreeTest {
    @Test
    public void test212() {
        char[][] board = {{'a', 'b'}, {'c', 'd'}};
        String[] words = {"abc", "abd", "bcd"};
        // char[][] board = {{'a'}};
        // String[] words = {"a"};
        System.out.println(findWords(board, words));
    }
    
    int rows;
    int cols;
    char[][] board;
    boolean[][] visited;
    
    HashSet<String> result = new HashSet<>();
    
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1},};
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        //初始值判断
        if (board == null || board.length == 0) {
            return list;
        }
        if (words == null || words.length == 0) {
            return list;
        }
        WordTrie trie = new WordTrie();
        for (String word : words) {
            trie.addWord(word);
        }
        //dfs算法对二维进行递归
        this.board = board;
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        TrieNode root = trie.root;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (root.containsKey(board[row][col])) {
                    dfs(root, row, col);
                }
            }
        }
        
        list.addAll(result);
        return list;
    }
    
    private void dfs(TrieNode node, int row, int col) {
        //结束条件
        if (!inBoard(row, col)) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        //查找currentNode后是否存在字母board[row][col]
        // 我们不能先在board中去搜索所有的单词后再去trie树中查找前缀匹配的
        // 正确的做法是在dfs搜索board的过程中trie树也跟着逐层搜索，看currentNode节
        // 点后是否存在当前(row,col)这个字母
        //如果当前节点后不存在该(i,j)字母,无需下探了直接返回
        char c = board[row][col];
        if (!node.containsKey(c)) {
            return;
        }
        
        //递归
        visited[row][col] = true;
        node = node.get(c);
        //当前层处理
        if (node.isEnd()) {
            result.add(node.getWord());
        }
        
        //下一层
        for (int[] ints : direction) {
            dfs(node, ints[0] + row, ints[1] + col);
        }
        
        //结束        
        visited[row][col] = false;
    }
    
    private boolean inBoard(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
    
    static class WordTrie {
        TrieNode root = new TrieNode();
        
        //构架字典树 
        public void addWord(String word) {
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
            //单词结尾
            node.setEnd();
            //需要记录单词
            node.setWord(word);
        }
        
    }
    
    static
    class TrieNode {
        private static final int R = 26;
        private boolean isEnd;
        private String word;
        private TrieNode[] children = new TrieNode[R];
        
        public TrieNode get(char c) {
            return children[c - 'a'];
        }
        
        public void put(char c, TrieNode trieNode) {
            children[c - 'a'] = trieNode;
        }
        
        public boolean containsKey(char c) {
            return children[c - 'a'] != null;
        }
        
        public TrieNode() {
        }
        
        public boolean isEnd() {
            return isEnd;
        }
        
        public void setEnd() {
            isEnd = true;
        }
        
        public String getWord() {
            return word;
        }
        
        public void setWord(String word) {
            this.word = word;
        }
        
    }
    
}

