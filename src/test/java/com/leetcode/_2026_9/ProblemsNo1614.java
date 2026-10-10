package com.leetcode._2026_9;

import org.junit.Test;


/**
 * 1614. 括号的最大嵌套深度
 *
 * @author DHW
 * @date 2026/9/28 8:40
 * @Version 1.0
*/
public class ProblemsNo1614 {

    @Test
    public void solution() {
        String s = "()(())((()()))";
        System.out.println("res = " + maxDepth(s));
    }

    public int maxDepth(String s) {
        int depth = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if(c == '(') {
                depth++;
                ans = Math.max(ans, depth);
            }else if(c == ')') {
                depth--;
            }
        }
        return ans;
    }
}

