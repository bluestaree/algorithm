package com.leetcode._2023_9;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * 210. 课程表II
 *
 * @author DHW
 * @date 2023/9/10 10:49
 * @Version 1.0
*/
public class ProblemsNo210 {

    @Test
    public void solution() {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{new int[]{1,3},new int[]{2,4}};
        System.out.println("res = " + findOrder(numCourses, prerequisites));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<Integer>());
        }
        int[] count = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            list.get(b).add(a);
            count[a]++;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < count.length; i++) {
            if(count[i] == 0) {
                deque.offer(i);
            }
        }

        int num = 0;
        int[] ans = new int[numCourses];
        while(!deque.isEmpty()) {
            Integer i = deque.poll();
            ans[num++] = i;
            List<Integer> target = list.get(i);
            for (int j = 0; j < target.size(); j++) {
                count[target.get(j)]--;
                if(count[target.get(j)] == 0) {
                    deque.offer(target.get(j));
                }
            }
        }
        return num == numCourses ? ans : new int[0];
    }
}
