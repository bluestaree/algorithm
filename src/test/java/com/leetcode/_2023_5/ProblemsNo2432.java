package com.leetcode._2023_5;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * 2432. 处理用时最长的那个任务的员工
 *
 * @author DHW
 * @date 2023/5/5 14:27
 * @Version 1.0
*/
public class ProblemsNo2432 {

    @Test
    public void solution() {
        int n = 1;
        int[][] logs = new int[][]{new int[]{1,2,3}};
        System.out.println("res = " + hardestWorker(n, logs));
    }

    public int hardestWorker(int n, int[][] logs) {
        int[] res = new int[2];
        int preLeaveTime = 0;
        for (int i = 0; i < logs.length; i++) {
            int[] log = logs[i];
            int interval = log[1] - preLeaveTime;
            preLeaveTime = log[1];
            if(interval < res[1]) {
                continue;
            }
            if(interval == res[1]) {
                res[0] = Math.min(res[0], log[0]);
            } else {
                res[0] = log[0];
            }
            res[1] = interval;
        }
        return res[0];
    }
}
