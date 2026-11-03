package com.leetcode._2026_10;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2748. 美丽下标对的数目
 *
 * @author DHW
 * @date 2026/10/20 8:55
 * @Version 1.0
*/
public class ProblemsNo2748 {

    @Test
    public void solution() {
        int[] nums = new int[]{2536,1613,3366,162};
        System.out.println("res = " + countBeautifulPairs(nums));
    }

    public int countBeautifulPairs(int[] nums) {
        int ans = 0;
        int[] counts = new int[10];
        for (int num : nums) {
            for (int i = 1; i < 10; i++) {
                if(counts[i] > 0 && gcd(num % 10, i) == 1) {
                    ans += counts[i];
                }
            }
            while (num >= 10) {
                num /= 10;
            }
            counts[num]++;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

