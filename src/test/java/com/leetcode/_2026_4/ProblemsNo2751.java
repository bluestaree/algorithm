package com.leetcode._2026_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * 2751. 机器人碰撞
 *
 * @author DHW
 * @date 2026/4/1 8: 42
 * @Version 1.0
 */
public class ProblemsNo2751 {

    @Test
    public void solution() {
        int[] positions = new int[]{3,5,2,6};
        int[] healths = new int[]{10,10,15,12};
        String directions = "RLRL";
        System.out.println("sortArrayByParity(nums) = " + survivedRobotsHealths(positions, healths, directions));
    }


    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> list = new ArrayList<>();
        int n = positions.length;
        Integer[] relIndex = new Integer[n];
        for (int i = 0; i < n; i++) {
            relIndex[i] = i;
        }
        Arrays.sort(relIndex, (a, b) -> positions[a] - positions[b]);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = directions.charAt(relIndex[i]);
            if(c == 'R') {
                stack.push(relIndex[i]);
                continue;
            }
            while (!stack.isEmpty() && directions.charAt(stack.peek()) == 'R') {
                    if(healths[stack.peek()] == healths[relIndex[i]]) {
                        healths[stack.pop()] = 0;
                        healths[relIndex[i]] = 0;
                        break;
                    } else if(healths[stack.peek()] > healths[relIndex[i]]) {
                        healths[stack.peek()]--;
                        healths[relIndex[i]] = 0;
                        break;
                    } else {
                        healths[stack.pop()] = 0;
                        healths[relIndex[i]]--;
                    }
            }
        }
        for (int health : healths) {
            if(health == 0) continue;
            list.add(health);
        }
        return list;
    }

}

