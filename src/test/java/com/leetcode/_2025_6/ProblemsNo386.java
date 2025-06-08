package com.leetcode._2025_6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 386. 字典序排数
 *
 * @author DHW
 * @date 2025/6/8 9: 55
 * @Version 1.0
*/
public class ProblemsNo386 {

    @Test
    public void solution() {
        System.out.println("res = " + lexicalOrder(11));
    }

    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 1; i < 10; i++){
            dfs(n, i, list);
        }
        return list;
    }

    private void dfs(int n, int i, ArrayList<Integer> list) {
        if(i > n) {
            return;
        }
        list.add(i);
        for(int j=0;j<=9;j++){
            dfs(n,i*10+j,list);
        }
    }
}

