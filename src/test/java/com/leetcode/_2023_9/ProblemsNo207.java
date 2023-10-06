package com.leetcode._2023_9;

import org.junit.Test;

import java.util.*;


/**
 * 207. 课程表
 *
 * @author DHW
 * @date 2023/9/9 9:25
 * @Version 1.0
*/
public class ProblemsNo207 {

    @Test
    public void solution() {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{new int[]{1,3},new int[]{2,4}};
        System.out.println("res = " + canFinish(numCourses, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while(!deque.isEmpty()) {
            Integer i = deque.poll();
            num++;
            List<Integer> target = list.get(i);
            for (int j = 0; j < target.size(); j++) {
                count[target.get(j)]--;
                if(count[target.get(j)] == 0) {
                    deque.offer(target.get(j));
                }
            }
        }
        return num == numCourses;
    }
}
