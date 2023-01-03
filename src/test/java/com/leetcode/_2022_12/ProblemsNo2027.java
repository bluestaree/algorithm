package com.leetcode._2022_12;

import org.junit.Test;


/**
 * 2027. 转换字符串的最少操作次数
 *
 * @author DHW
 * @date 2022/12/27 13:40
 * @Version 1.0
*/
public class ProblemsNo2027 {

    @Test
    public void solution() {
        String s = "XXOOOXOOXOOXOOOXXOOOXOOXOXXXXXXOOXOOOXOOOOOXOXXOOOOXOOXXOXOXXOXOOOOOXOXOXOXXXOOOXOOXXXXOOXXOOXXOXOXOXOOOXOOOOXXXXXOXXXOOXOOXXOXOOOOXOOOOXXOOXXXOXOXOXXXXXOOXXXOOXOOOOXOOOOXXXXXXXOOXOOOXXXXXOXXOOOOXOOXOOXOOOXOXOXOOXXXOXXXXOXOOOXOXOOXOOOOXXOOXXOXOOXOXXXOXOXOOXOXOXXOXOOXXXOXXOOOOXOXXOOXOOOOOOXOOOXXOXXOXXOXOOOOOXXOXXOXOXXOXXOOOOXOOOOXXXOXOXXXXOOOOXOOXOXOOOXOOXOXOXXXXXXXOXOXOOXXOXXOXOXOOOOXO";
        System.out.println("res = " + minimumMoves(s));
    }

    public int minimumMoves(String s) {
        int res = 0;
        while (true) {
            int index = s.indexOf("X");
            if(index == -1) {
                break;
            }
            res++;
            if(s.length() - index < 3) {
                break;
            }
            s = s.substring(index + 3);
        }
        return res;
    }
}
