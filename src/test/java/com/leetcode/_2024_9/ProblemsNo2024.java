package com.leetcode._2024_9;

import org.junit.Test;


/**
 * 2024. 考试的最大困扰度
 *
 * @author DHW
 * @date 2024/9/2 9:30
 * @Version 1.0
*/
public class ProblemsNo2024 {

    @Test
    public void solution() {
        String answerKey = "TFFT";
        int k = 1;
        System.out.println("res = " + maxConsecutiveAnswers(answerKey, k));
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] array = answerKey.toCharArray();
        int res = 0;
        int countT = 0;
        int startIndex = 0;
        for (int lastIndex = 0; lastIndex < array.length; lastIndex++) {
            if(array[lastIndex] == 'T') {
                countT++;
            }
            int len = lastIndex - startIndex + 1;
            int num = Math.min(len - countT, countT);
            if(num > k) {
                if(array[startIndex++] == 'T') {
                    countT--;
                }
            } else {
                res = Math.max(res, len);
            }
        }
        return res;
    }
}

