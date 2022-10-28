package com.leetcode._2022_10;

import org.junit.Test;

import java.util.*;


/**
 * 856. 括号的分数
 *
 * @author DHW
 * @date 2022/10/9 10:43
 * @Version 1.0
*/
public class ProblemsNo856 {

    @Test
    public void solution() {
//        String s = "((()))";
//        String s = "(()(()))";
        String s = "()(()())";
        System.out.println("s = " + scoreOfParentheses(s));
    }

    public int scoreOfParentheses(String s) {
        Deque<Character> deque = new ArrayDeque();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') deque.addLast('(');
            else {
                char c = deque.removeLast();
                if (c == '(') {
                    deque.addLast('1');
                } else {
                    int sum = c - '0';
                    while ((c = deque.removeLast()) != '(')  sum += c - '0';
                    deque.addLast((char) ((sum << 1) + '0'));
                }
            }
        }
        int result = 0;
        while (!deque.isEmpty()) result += deque.removeLast() - '0';
        return result;
    }

    public int scoreOfParentheses1(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        int[] mark = new int[chars.length];
        Stack<Integer> stack = new Stack<>();
        int partSum = 0;
        int part = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ')') {
                Integer pop = stack.pop();
                if(mark[pop] == 0) {
                    if(stack.isEmpty()) {
                        sum++;
                        continue;
                    }
                    if(partSum != 0) {
                        sum += partSum;
                        partSum = 0;
                        continue;
                    }
                    partSum = 1;
                } else {
                    if(partSum != 0) {
                        if(part!=0) {
                            sum = (sum + partSum) * 2;
                            part--;
                        } else {
                            sum = sum + (partSum * 2);
                            partSum = 0;
                        }
                    } else {
                        sum = sum * 2;
                    }
                }
            } else if(chars[i] == '(') {
                if(partSum != 0) {
                    sum += partSum;
                    partSum = 0;
                    part++;
                }
                if(!stack.isEmpty()) {
                    if(stack.peek() == i-1) {
                        mark[i-1] = 1;
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }

}
