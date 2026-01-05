package com.leetcode._2025_12;

import org.junit.Test;


/**
 * 2024. 考试的最大困扰度
 *
 * @author DHW
 * @date 2025/12/25 9: 03
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
        int ans = 0;
        int left = 0;
        int[] cnt = new int[2];
        char[] charArray = answerKey.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            cnt[(charArray[i] & 2) >> 1]++;
            while (Math.min(cnt[0], cnt[1]) > k) {
                cnt[(charArray[left] & 2) >> 1]--;
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }

        return ans;
    }
}

