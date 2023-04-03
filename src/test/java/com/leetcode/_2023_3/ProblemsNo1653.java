package com.leetcode._2023_3;

import org.junit.Test;


/**
 * 1653. 使字符串平衡的最少删除次数
 *
 * @author DHW
 * @date 2023/3/6 9:02
 * @Version 1.0
*/
public class ProblemsNo1653 {

    @Test
    public void solution() {
        String s = "aaababababb";
        System.out.println("res = " + minimumDeletions(s));
    }

    public int minimumDeletions(String s) {
        int la = 0;
        int rb = 0;
        int n = s.length();
        int res = n;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == 'a') {
                la++;
            }
        }
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == 'a') {
                --la;
            }
            res = Math.min(res, la + rb);
            if(s.charAt(i) == 'b') {
                ++rb;
            }
        }
        return res;
    }
}
