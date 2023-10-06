package com.leetcode._2023_9;

import org.junit.Test;

import java.util.HashSet;


/**
 * 2240. 买钢笔和铅笔的方案数
 *
 * @author DHW
 * @date 2023/9/1 10:34
 * @Version 1.0
*/
public class ProblemsNo2240 {

    @Test
    public void solution() {
        int total = 20;
        int cost1 = 10;
        int cost2 = 5;
        System.out.println("res = " + waysToBuyPensPencils(total, cost1, cost2));
    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        for (int i = 0; ; i++) {
            int num1 = i * cost1;
            int count = total - num1;
            if(count < 0) {
                break;
            }
            res = res + (count / cost2) + 1;
        }
        return res;
    }
}
