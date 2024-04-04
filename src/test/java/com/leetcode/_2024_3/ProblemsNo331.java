package com.leetcode._2024_3;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;


/**
 * 331. 验证二叉树的前序序列化
 *
 * @author DHW
 * @date 2024/3/31 10:53
 * @Version 1.0
*/
public class ProblemsNo331 {

    @Test
    public void solution() {
        String preorder = "9,3,4,#,#,1,#,#,#,2,#,6,#,#";
        System.out.println("res = " + isValidSerialization(preorder));
    }

    public boolean isValidSerialization(String preorder) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        for (String s : preorder.split(",")) {
            if(deque.isEmpty()) {
                return false;
            }
            if(s.equals("#")) {
                while (!deque.isEmpty()) {
                    int i = deque.pop() - 1;
                    if(i > 0) {
                        deque.push(1);
                        break;
                    }
                }
            } else {
                deque.push(2);
            }
        }
        return deque.isEmpty();
    }

}

