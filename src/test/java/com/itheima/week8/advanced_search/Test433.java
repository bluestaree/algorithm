package com.itheima.week8.advanced_search;

import java.util.*;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-10-06 14:38
 **/
public class Test433 {
    @org.junit.Test
    public void test433最小基因变化() {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(minMutation(start, end, bank));
    }
    
    public int minMutation(String start, String end, String[] bank) {
        //初始值判断,不好判断,跳过
        
        //bfs,双向
        Queue<String> q1 = new LinkedList<>();
        q1.add(start);
        Queue<String> q2 = new LinkedList<>();
        q2.add(end);
        Set<String> set = new HashSet<String>(Arrays.asList(bank));
        Set<String> s1 = new HashSet<String>();
        s1.add(start);
        Set<String> s2 = new HashSet<String>();
        s2.add(end);
        int res = 0;
        char[] enums = new char[]{'A', 'C', 'G', 'T'};
        if (!set.contains(end)) {
            return -1;
        }
        //
        while (!q1.isEmpty() && !q2.isEmpty()) {
            res++;
            if (q1.size() > q2.size()) {
                //交互,把小的拿来循环
                Queue<String> tmpQ = q1;
                q1 = q2;
                q2 = tmpQ;
                Set<String> tmpS = s1;
                s1 = s2;
                s2 = tmpS;
            }
            //
            int size = q1.size();
            for (int k = 0; k < size; k++) {
                String str = q1.poll();
                char[] arr = str.toCharArray();
                for (int i = 0; i < 8; i++) {
                    char ch = arr[i];
                    for (char c : enums) {
                        if (ch == c) {
                            continue;
                        }
                        //替换其中一个字符
                        arr[i] = c;
                        String next = new String(arr);
                        if (s1.contains(next)) {
                            continue;
                        }
                        if (s2.contains(next)) {
                            return res;
                        }
                        if (set.contains(next)) {
                            q1.add(next);
                            s1.add(next);
                        }
                    }
                    arr[i] = ch;
                }
            }
        }
        //
        return -1;
    }
}
