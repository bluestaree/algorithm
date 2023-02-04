package com.leetcode._2023_1;

import org.junit.Test;

import java.time.Instant;
import java.util.*;


/**
 * 1817. 查找用户活跃分钟数
 *
 * @author DHW
 * @date 2023/1/20 12:26
 * @Version 1.0
*/
public class ProblemsNo1817 {

    @Test
    public void solution() {
        int[][] logs = new int[][]{new int[]{0, 5}, new int[]{1, 2}, new int[]{0, 2}, new int[]{0, 5}, new int[]{1, 3}};
        int k = 5;
        System.out.println("res = " + findingUsersActiveMinutes(logs, k));
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, Set> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            int userId = logs[i][0];
            Set set = map.get(userId);
            if(set == null) {
                set = new HashSet();
            }
            int execTime = logs[i][1];
            set.add(execTime);
            map.put(userId, set);
        }
        int[] answer = new int[k];
        for (Set value : map.values()) {
            int size = value.size();
            answer[size - 1]++;
        }
        return answer;
    }
}