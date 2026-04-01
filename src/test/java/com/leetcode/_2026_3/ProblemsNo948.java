package com.leetcode._2026_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 948. 令牌放置
 *
 * @author DHW
 * @date 2026/3/19 13: 45
 * @Version 1.0
*/
public class ProblemsNo948 {

    @Test
    public void solution() {
        int[] tokens = new int[]{100,200,300,400};
        int power = 200;
        System.out.println("res = " + bagOfTokensScore(tokens, power));
    }


    public int bagOfTokensScore(int[] tokens, int power) {
        int ans = 0;
        int temp = 0;
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left++];
                temp++;
            } else if (temp > 0) {
                power += tokens[right--];
                ans = Math.max(ans, temp);
                temp--;
            } else {
                break;
            }
        }
        return Math.max(ans, temp);
    }

}

