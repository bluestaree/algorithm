package com.leetcode._2022_9;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 799. 旋转数字
 *
 * @author DHW
 * @date 2022/9/25 13:09
 * @Version 1.0
*/
public class ProblemsNo788 {

    @Test
    public void solution() {
        System.out.println("true = " + rotatedDigits(10));
    }


    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int val = i;
            int count = 0;
            while (val > 0) {
                int temp = val % 10;
                if (temp == 2 || temp == 5 || temp == 6 || temp == 9) {
                    count = 1;
                } else if (temp == 3 || temp == 4 || temp == 7) {
                    count = 0;
                    break;
                }
                val = val / 10;
            }
            ans += count;
        }
        return ans;
    }
}
