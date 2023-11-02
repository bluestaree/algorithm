package com.leetcode._2023_10;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2678. 老人的数目
 *
 * @author DHW
 * @date 2023/10/23 9:19
 * @Version 1.0
*/
public class ProblemsNo2678 {

    @Test
    public void solution() {
        String[] details = new String[]{"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println("res = " + countSeniors(details));
    }

    public int countSeniors(String[] details) {
        int res = 0;
        for (int i = 0; i < details.length; i++) {
            String detail = details[i];
            String age = detail.substring(11, 13);
            if(Integer.parseInt(age) > 60) {
                res++;
            }
        }
        return res;
    }
}

