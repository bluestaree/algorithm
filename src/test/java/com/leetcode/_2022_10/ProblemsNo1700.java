package com.leetcode._2022_10;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;


/**
 * 1700. 无法吃午餐的学生数量
 *
 * @author DHW
 * @date 2022/10/19 9:28
 * @Version 1.0
*/
public class ProblemsNo1700 {

    @Test
    public void solution() {
        int[] students = new int[]{1,1,1,0,0,1};
        int[] sandwiches = new int[]{1,0,0,0,1,1};
        System.out.println("arr = " + countStudents(students, sandwiches));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int s0 = Arrays.stream(students).sum();
        int s1 = students.length - s0;
        for (int sandwich : sandwiches) {
            if(sandwich == 0 && s1 > 0) {
                s1--;
                continue;
            }
            if(sandwich == 1 && s0 > 0) {
                s0--;
                continue;
            }
            break;
        }
        return s0 + s1;
    }

    public int countStudents1(int[] students, int[] sandwiches) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = students.length - 1; i >= 0; i--) {
            deque.add(students[i]);
        }
        int count = 0;
        for (int i = 0; i < sandwiches.length; i++) {
            Integer pop = deque.pop();
            if(pop == sandwiches[i]) {
                count = 0;
                continue;
            } else {
                deque.addLast(pop);
                if(count > deque.size()) {
                    break;
                }
                i--;
                count++;
            }
        }
        return deque.size();
    }
}
