package com.leetcode._2023_7;

import org.junit.Test;

import java.util.*;


/**
 * 874. 模拟行走机器人
 *
 * @author DHW
 * @date 2023/7/19 10:28
 * @Version 1.0
*/
public class ProblemsNo874 {

    @Test
    public void solution() {
        int[] commands = new int[]{-2,-1,8,9,6};
        int[][] obstacles = new int[][]{new int[]{0,1}};
        System.out.println("res = " + robotSim(commands, obstacles));
    }

    Set<Integer> set = new HashSet<>();
    public int robotSim(int[] commands, int[][] obstacles) {

        for (int i = 0; i < obstacles.length; i++) {
            set.add(f(obstacles[i][0], obstacles[i][1]));
        }

        int res = 0;
        int[] pos = new int[]{0,0,0};
        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];

            if(command < 0) {
                change(pos, command);
                continue;
            }

            res = Math.max(res, move(pos, command));
        }
        return res;
    }

    private Integer f(int x, int y) {
        return x * 60010 + y;
    }

    private int move(int[] pos, int command) {
        int faceTarget = pos[0];
        int x = pos[1];
        int y = pos[2];
        List<Integer> list;
        switch (faceTarget) {
            case 0:
                for (int i = 0; i < command; i++) {
                    if(set.contains(f(x, y + 1))) break;
                    y += 1;
                }
                break;
            case 2:
                for (int i = 0; i < command; i++) {
                    if(set.contains(f(x, y - 1))) break;
                    y -= 1;
                }
                break;
            case 1:
                for (int i = 0; i < command; i++) {
                    if(set.contains(f(x + 1, y))) break;
                    x += 1;
                }
                break;
            case 3:
                for (int i = 0; i < command; i++) {
                    if(set.contains(f(x - 1, y))) break;
                    x -= 1;
                }
                break;
        }
        pos[1] = x;
        pos[2] = y;
        return x * x + y * y;
    }

    private void change(int[] pos, int command) {
        int faceTarget = pos[0];
        if(command == -1) {
            faceTarget = faceTarget == 3 ? 0 : faceTarget + 1;
        } else {
            faceTarget = faceTarget == 0 ? 3 : faceTarget - 1;
        }
        pos[0] = faceTarget;
    }
}
