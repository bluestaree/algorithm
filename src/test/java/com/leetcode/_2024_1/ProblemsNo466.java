package com.leetcode._2024_1;

import org.junit.Test;


/**
 * 466. 统计重复个数
 *
 * @author DHW
 * @date 2024/1/2 10:49
 * @Version 1.0
*/
public class ProblemsNo466 {

    @Test
    public void solution() {
        String s1 = "baba";
        int n1 = 11;
        String s2 = "baab";
        int n2 = 2;
        System.out.println("res = " + getMaxRepetitions(s1, n1, s2, n2));
    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();

        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        int index2 = 0;
        // s2 循环了几次
        int loopTimesOnS2 = 0;

        for (int i = 0; i < n1; i++) {
            for (int index1 = 0; index1 < len1; index1++) {
                if (charArray1[index1] == charArray2[index2]) {
                    index2++;

                    // 如果 index2 遍历到末尾，循环计数器加 1，index2 重置到开头
                    if (index2 == len2) {
                        index2 = 0;
                        loopTimesOnS2++;
                    }
                }
            }
        }
        return loopTimesOnS2 / n2;
    }
}

