package com.leetcode._2023_3;

import org.junit.Test;


/**
 * 0502. 二进制数转字符串
 *
 * @author DHW
 * @date 2023/3/2 10:21
 * @Version 1.0
*/
public class ProblemsNo0502 {

    @Test
    public void solution() {
        double num = 0.625;
        System.out.println("res = " + printBin(num));
    }

    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        for (int i = 0; i < 32 && num != 0; i++) {
            num *= 2;
            int x = (int)num;
            sb.append(x);
            num -= x;
        }
        return num != 0 ? "ERROR" : sb.toString();
    }
}
