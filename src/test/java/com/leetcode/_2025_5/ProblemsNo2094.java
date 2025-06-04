package com.leetcode._2025_5;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 2094. 找出 3 位偶数
 *
 * @author DHW
 * @date 2025/5/12 9: 11
 * @Version 1.0
*/
public class ProblemsNo2094 {

    @Test
    public void solution() {
        int[] digits = new int[]{0,2,1,5,3,4};
        System.out.println("res = " + findEvenNumbers(digits));
    }

    public int[] findEvenNumbers(int[] digits) {
        int c = 0;
        for (int digit : digits) {
            c += (digit & 1) == 1 ? 0 : 1;
        }
        if(c == 0) {
            return new int[]{};
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            if((digits[i] & 1) == 0) {
                for (int j = 0; j < digits.length; j++) {
                    if(j == i || digits[j] == 0) {
                        continue;
                    }
                    for (int k = 0; k < digits.length; k++) {
                        if(k == i || k == j) {
                            continue;
                        }
                        set.add(digits[j] * 100 + digits[k] * 10 + digits[i]);
                    }
                }
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}

