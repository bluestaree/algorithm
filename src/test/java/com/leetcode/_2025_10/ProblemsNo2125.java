package com.leetcode._2025_10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 2125. 银行中的激光束数量
 *
 * @author DHW
 * @date 2025/10/27 8: 52
 * @Version 1.0
 */
public class ProblemsNo2125 {

    @Test
    public void solution() {
        String[] bank = new String[]{"011001", "000000", "010100", "001000"};
        System.out.println("res = " + numberOfBeams(bank));
    }

    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int pre = 0;
        for (String s : bank) {
            int cur = 0;
            for (char c : s.toCharArray()) {
                if(c == '1') {
                    cur++;
                }
            }
            if (cur > 0) {
                ans += pre * cur;
                pre = cur;
            }
        }
        return ans;
    }

}

