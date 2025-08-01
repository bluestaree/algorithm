package com.leetcode._2025_7;

import org.junit.Test;

import java.util.Stack;


/**
 * 1717. 删除子字符串的最大得分
 *
 * @author DHW
 * @date 2025/7/23 9: 17
 * @Version 1.0
*/
public class ProblemsNo1717 {

    @Test
    public void solution() {
        String s = "cdbcbbaaabab";
        int x = 4;
        int y = 5;
        System.out.println("res = " + maximumGain(s, x, y));
    }

    public int maximumGain(String s, int x, int y) {
        int ans = 0;
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        int[] a = new int[4];

        if(x > y) {
            a[0] = 'a';
            a[1] = 'b';
            a[2] = x;
            a[3] = y;
        } else {
            a[0] = 'b';
            a[1] = 'a';
            a[2] = y;
            a[3] = x;
        }

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(!s1.empty()) {
                if(s1.peek() == a[0] && charArray[i] == a[1]){
                    s1.pop();
                    ans += a[2];
                    continue;
                }
            }
            s1.push(charArray[i]);
        }
        while (!s1.empty()) {
            Character c = s1.pop();
            if(!s2.isEmpty()) {
                if(s2.peek() == a[0] && c == a[1]){
                    s2.pop();
                    ans += a[3];
                    continue;
                }
            }
            s2.push(c);
        }
        return ans;
    }
}

