package com.leetcode._2024_6;

import org.junit.Test;



/**
 * 2288. 价格减免
 *
 * @author DHW
 * @date 2024/6/18 8:49
 * @Version 1.0
*/
public class ProblemsNo2288 {

    @Test
    public void solution() {
        String sentence = "1$2";
        int discount = 4;
        System.out.println("res = " + discountPrices(sentence, discount));
    }

    public String discountPrices(String sentence, int discount) {
        double d = 1 - discount / 100.0;
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while((i = sentence.indexOf("$", i)) != -1) {
            sb.append(sentence.substring(j, i+1));
            j = i + 1;
            i = sentence.indexOf(" ", i);
            if(i < 0) {
                i = sentence.length();
            }
            if(j - 2 >= 0 && sentence.charAt(j-2) != ' ') {
                continue;
            }
            if(checkNum(sentence, j, i)) {
                sb.append(String.format("%.2f", Long.parseLong(sentence.substring(j, i)) * d));
                j = i;
            }
        }
        sb.append(sentence.substring(j));
        return sb.toString();
    }

    private boolean checkNum(String sentence, int i, int j) {
        if(i == j) {
            return false;
        }
        for (; i < j; i++) {
            char c = sentence.charAt(i);
            if(c < 48 || c > 57) {
                return false;
            }
        }
        return true;
    }
}

