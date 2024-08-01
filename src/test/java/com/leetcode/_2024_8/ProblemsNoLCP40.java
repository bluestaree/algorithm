package com.leetcode._2024_8;

import org.junit.Test;

import java.util.Arrays;


/**
 * LCP 40. 心算挑战
 *
 * @author DHW
 * @date 2024/8/1 11:00
 * @Version 1.0
*/
public class ProblemsNoLCP40 {

    @Test
    public void solution() {
        int[] cards = new int[]{7,4,1};
        int cnt = 1;
        System.out.println("res = " + maxmiumScore(cards, cnt));
    }

    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int n = cards.length;
        int index = n - cnt;
        int sum = 0;
        for (int i = n - 1; i >= index; i--) {
            sum += cards[i];
        }
        if(sum % 2 == 0) {
            return sum;
        }
        for (int i = index - 1; i >= 0; i--) {
            for (int j = index; j < n; j++) {
                sum -= cards[j];
                sum += cards[i];
                if(sum % 2 == 0) {
                    return sum;
                }
                sum += cards[j];
                sum -= cards[i];
            }
        }
        return 0;
    }
}

