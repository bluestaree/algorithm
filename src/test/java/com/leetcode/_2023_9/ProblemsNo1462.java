package com.leetcode._2023_9;

import org.junit.Test;

import java.util.*;


/**
 * 1462. 课程表 IV
 *
 * @author DHW
 * @date 2023/9/12 11:23
 * @Version 1.0
*/
public class ProblemsNo1462 {

    @Test
    public void solution() {
        int numCourses = 10;
        int[][] prerequisites = new int[][]{new int[]{2,8}, new int[]{8,5}};
        int[][] queries = new int[][]{new int[]{2,8}};
        System.out.println("res = " + checkIfPrerequisite(numCourses, prerequisites, queries));
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[][] grid = new int[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            grid[a][b] = 1;
        }

        for (int k = 0; k < numCourses; ++k) {
            for (int i = 0; i < numCourses; ++i) {
                if(grid[i][k] == 1) {
                    for (int j = 0; j < numCourses; ++j) {
                        if(grid[k][j] == 1) {
                            grid[i][j] = 1;
                        }
                    }
                }
            }
        }

        ArrayList<Boolean> res = new ArrayList<>();

        for (int[] query : queries) {
            res.add(grid[query[0]][query[1]] == 1);
        }

        return res;
    }
}
