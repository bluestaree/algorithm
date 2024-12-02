package com.leetcode._2024_11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 3248. 矩阵中的蛇
 *
 * @author DHW
 * @date 2024/11/21 8: 52
 * @Version 1.0
*/
public class ProblemsNo3248 {

    @Test
    public void solution() {
        int n = 3;
        List<String> commands = new ArrayList<>();
        commands.add("RIGHT");
        commands.add("DOWN");
        commands.add("UP");
        System.out.println("res = " + finalPositionOfSnake(n, commands));
    }

    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int j = 0;
        for (String command : commands) {
            switch (command.charAt(0)) {
                case 'U':
                    i--;
                    break;
                case 'D':
                    i++;
                    break;
                case 'L':
                    j--;
                    break;
                default:
                    j++;
            }
        }
        return (i * n) + j;
    }
}

