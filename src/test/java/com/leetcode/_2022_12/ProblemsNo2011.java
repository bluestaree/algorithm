package com.leetcode._2022_12;

import org.junit.Test;


/**
 * 2011. 执行操作后的变量值
 *
 * @author DHW
 * @date 2022/12/23 15:01
 * @Version 1.0
*/
public class ProblemsNo2011 {

    @Test
    public void solution() {
        String[] nums = new String[]{"++X","++X","X++"};
        System.out.println("res = " + finalValueAfterOperations(nums));
    }

    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i];
            if(operation.indexOf("+") >= 0) {
                res++;
            } else {
                res--;
            }
        }
        return res;
    }
}
