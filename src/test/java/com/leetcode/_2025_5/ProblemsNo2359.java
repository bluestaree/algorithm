package com.leetcode._2025_5;

import org.junit.ClassRule;
import org.junit.Test;


/**
 * 2359. 找到离给定两个节点最近的节点
 *
 * @author DHW
 * @date 2025/5/30 8: 38
 * @Version 1.0
 */
public class ProblemsNo2359 {

    @Test
    public void solution() {
        int[] edges = new int[]{1,2,-1};
        System.out.println("res = " + closestMeetingNode(edges, 0, 2));
    }

    int res;
    int preMax;

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[][] v1 = new int[n][1];
        int len = 1;
        v1[node1][0] = len++;
        int next = edges[node1];
        while(next != -1 && v1[next][0] == 0) {
            v1[next][0] = len++;
            next = edges[next];
        }

        res = -1;
        preMax = n + 1;
        int[][] v2 = new int[n][1];
        len = 1;
        v2[node2][0] = len++;
        check(v1, v2, node2);
        next = edges[node2];
        while(next != -1 && v2[next][0] == 0) {
            v2[next][0] = len++;
            check(v1, v2, next);
            next = edges[next];
        }
        return res;
    }

    private void check(int[][] v1, int[][] v2, int curNode) {
        if(v1[curNode][0] == 0) {
            return;
        }
        int maxNum = Math.max(v1[curNode][0], v2[curNode][0]);
        if(maxNum == preMax && res > curNode) {
            res = curNode;
            return;
        }
        if (maxNum < preMax) {
            res = curNode;
            preMax = maxNum;
        }
    }
}

