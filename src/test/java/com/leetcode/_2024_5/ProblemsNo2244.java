package com.leetcode._2024_5;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * 2244. 完成所有任务需要的最少轮数
 *
 * @author DHW
 * @date 2024/5/14 8:33
 * @Version 1.0
*/
public class ProblemsNo2244 {

    @Test
    public void solution() {
        int[] tasks = new int[]{2,2,3,3,2,4,4,4,4,4};
        System.out.println("res = " + minimumRounds(tasks));
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.merge(task, 1, Integer::sum);
        }
        int res = 0;
        for (int c : map.values()) {
            if (c == 1) {
                return -1;
            }
            res += (c + 2) / 3;
        }
        return res;
    }
}

