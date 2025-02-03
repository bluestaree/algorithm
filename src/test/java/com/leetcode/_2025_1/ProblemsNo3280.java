package com.leetcode._2025_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3280. 将日期转换为二进制表示
 *
 * @author DHW
 * @date 2025/1/1 11: 18
 * @Version 1.0
*/
public class ProblemsNo3280 {

    @Test
    public void solution() {
        String date = "2080-02-29";
        System.out.println("res = " + convertDateToBinary(date));
    }

    public String convertDateToBinary(String date) {
        StringBuilder sb = new StringBuilder();
        String[] split = date.split("-");
        for (String data : split) {
            int i = Integer.parseInt(data);
            sb.append(Integer.toBinaryString(i));
            sb.append("-");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

