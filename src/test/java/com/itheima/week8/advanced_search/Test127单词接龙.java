package com.itheima.week8.advanced_search;

import org.junit.Test;

import java.util.*;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-28 11:11
 **/
public class Test127单词接龙 {
    @Test
    public void test127单词接龙() {
        String[] str = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        
        System.out.println(ladderLength("hit", "cog", Arrays.asList(str)));
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //    初始值判断
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        HashSet<String> visitedSet1 = new HashSet<>();
        HashSet<String> visitedSet2 = new HashSet<>();
        
        queue1.add(beginWord);
        visitedSet1.add(beginWord);
        
        queue2.add(endWord);
        visitedSet2.add(endWord);
        
        int result = 0;
        //queue其中一个可以循环
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            result++;
            //对小的进行bfs
            if (queue1.size() > queue2.size()) {
                Queue<String> tmpq = queue1;
                queue1 = queue2;
                queue2 = tmpq;
                HashSet<String> tmps = visitedSet1;
                visitedSet1 = visitedSet2;
                visitedSet2 = tmps;
            }
            int size = queue1.size();
            for (int i1 = 0; i1 < size; i1++) {
                String word = queue1.poll();
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char ch = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        //需要替换其中一个char,看看是否能找到终点
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (visitedSet1.contains(newWord)) {
                            continue;
                        }
                        //如果在对方的访问列表中找到,说明可以达到
                        if (visitedSet2.contains(newWord)) {
                            return result + 1;
                        }
                        //
                        if (wordSet.contains(newWord)) {
                            queue1.add(newWord);
                            visitedSet1.add(newWord);
                        }
                    }
                    chars[i] = ch;
                }
            }
        }
        
        return 0;
    }
    
    public int ladderLength22(String beginWord, String endWord, List<String>
            wordList) {
        Set<String> wordSet = new HashSet(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        } //用于从beginWord开始搜索
        Queue<String> queue1 = new LinkedList();
        Set<String> visited1 = new HashSet();
        queue1.offer(beginWord);
        visited1.add(beginWord);
//用于从endWord开始搜索
        Queue<String> queue2 = new LinkedList();
        Set<String> visited2 = new HashSet();
        queue2.offer(endWord);
        visited2.add(endWord);
//定义最短转换序列的长度
        int minCount = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            minCount++;
/*
比较一下queue1和queue2中元素个数,我们每次都选择从单词数量小的集合开始
扩散
相当于选择该顶点下一层中顶点个数少的进行搜索，这样搜索总次数是最少的
*/
//我们记queue1是数量少的集合
            if (queue1.size() > queue2.size()) { //交换
                Queue<String> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
//对应的visited也需要交换
                Set<String> vtemp = visited1;
                visited1 = visited2;
                visited2 = vtemp;
            } //开始进行搜索       
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue1.poll();
                char[] currentWords = currentWord.toCharArray();
                for (int j = 0; j < currentWords.length; j++) {
                    char origin = currentWords[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        currentWords[j] = c;
                        String newWord = new String(currentWords);
//访问过了,跳过
                        if (visited1.contains(newWord)) {
                            continue;
                        } //两端遍历相遇，结束遍历，返回count
                        if (visited2.contains(newWord)) {
                            return minCount + 1;
                        } //如果单词在列表中存在，将其添加到队列，并标记为已访问
                        if (wordSet.contains(newWord)) {
                            queue1.offer(newWord);
                            visited1.add(newWord);
                        }
                    } //复位
                    currentWords[j] = origin;
                }
            }
        }
        return 0;
    }
    
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        //    初始值判断
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);
        int result = 1;
        //其他情况
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        HashSet<String> visitSet = new HashSet<>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i1 = 0; i1 < n; i1++) {
                String word = queue.poll();
                if (canConvert(visitSet, word, endWord, queue, wordSet)) {
                    return result + 1;
                }
                
            }
            result++;
        }
        return 0;
    }
    
    private boolean canConvert(HashSet<String> visitSet, String word, String
            endWord, Queue<String> queue, HashSet<String> wordSet) {
        
        char[] chars = word.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            char ch = chars[j];
            //替换其中一个元素
            for (char i = 'a'; i <= 'z'; i++) {
                if (ch == i) {
                    continue;
                }
                //其他情况
                chars[j] = i;
                String newWord = new String(chars);
                if (newWord.equals(endWord)) {
                    //结束了,就是这个
                    return true;
                }
                if (wordSet.contains(newWord) && !visitSet.contains(newWord)) {
                    queue.add(newWord);
                    visitSet.add(word);
                }
            }
            //复位
            chars[j] = ch;
        }
        return false;
    }
    
}
