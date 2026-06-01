package com.leetcode._2026_5;

import org.junit.Test;


/**
 * 2038. 如果相邻两个颜色均相同则删除当前颜色
 *
 * @author DHW
 * @date 2026/5/22 10: 23
 * @Version 1.0
 */
public class ProblemsNo2038 {

    @Test
    public void solution() {
        String colors = "AAABABB";
        System.out.println("res = " + winnerOfGame(colors));
    }

    public boolean winnerOfGame(String colors) {
        char[] charArray = colors.toCharArray();
        int a = 0, b = 0;
        for(int i = 1 ; i < charArray.length - 1 ; i++) {
            if(charArray[i] == charArray[i - 1] && charArray[i] == charArray[i + 1]) {
                if(charArray[i] == 'A') {
                    a++;
                } else {
                    b++;
                }
            }
        }
        return a > b;
    }
}

