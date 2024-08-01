package com.leetcode._2024_7;

import org.junit.Test;

import java.util.ArrayDeque;


/**
 * 682. 棒球比赛
 *
 * @author DHW
 * @date 2024/7/29 10:25
 * @Version 1.0
*/
public class ProblemsNo682 {

    @Test
    public void solution() {
        String[] operations = new String[]{"5","-2","4","C","D","9","+","+"};
        System.out.println("res = " + calPoints(operations));
    }

    public int calPoints(String[] operations) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (String operation : operations) {
            if(operation.equals("+")) {
                Integer a = deque.pop();
                Integer b = deque.peek();
                deque.push(a);
                deque.push(a + b);
            } else if (operation.equals("D")) {
                deque.push(deque.peek() << 1);
            } else if (operation.equals("C")) {
                deque.pop();
            } else {
                deque.push(Integer.parseInt(operation));
            }
        }
        int res = 0;
        while(!deque.isEmpty()) {
            res += deque.pop();
        }
        return res;
    }
}

