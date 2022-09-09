package com.itheima.week8.trie_tree.trie212;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-10-05 10:51
 **/
public class TrieTreeTest {
    @Test
    public void test212单词搜索II() {
        char[][] board = {{'a', 'b'}, {'c', 'd'}};
        String[] words = {"abc", "abd", "bcd"};
        // char[][] board = {{'a'}};
        // String[] words = {"a"};
        System.out.println(findWords(board, words));
    }
    
    Set<String> res = new HashSet<>();
    
    boolean[][] visited;
    char[][] board;
    int rows;
    int cols;
    
    public List<String> findWords(char[][] board1, String[] words) {
        board = board1;
        WordTrie trie = new WordTrie();
        for (String word : words) {
            trie.addWord(word);
        }
        //需要进行回溯搜索,
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(i, j, trie.root);
            }
        }
        return new ArrayList<>(res);
    }
    
    private void dfs(int i, int j, WordTrie.TrieNode now) {
        //结束条件
        //数组越界,被使用过
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j]) {
            return;
        }
        //
        char c = board[i][j];
        if (!now.containsKey(c)) {
            //不包含当前的字符
            return;
        }
        
        //回溯
        //选择
        visited[i][j] = true;
        
        //下一层
        WordTrie.TrieNode son = now.get(c);
        if (son.isEnd()) {
            //记录下节点
            res.add(son.getWord());
        }
        dfs(i - 1, j, son);
        dfs(i + 1, j, son);
        dfs(i, j - 1, son);
        dfs(i, j + 1, son);
        
        //撤回
        visited[i][j] = false;
        //
    }
    
    static
    class WordTrie {
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
        
        static class TrieNode {
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
    
}
