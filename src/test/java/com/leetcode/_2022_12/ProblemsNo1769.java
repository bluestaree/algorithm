package com.leetcode._2022_12;

import org.junit.Test;


/**
 * 1769. 移动所有球到每个盒子所需的最小操作数
 *
 * @author DHW
 * @date 2022/12/2 10:17
 * @Version 1.0
*/
public class ProblemsNo1769 {

    @Test
    public void solution() {
        String boxes = "001011";
        System.out.println("res = " + minOperations(boxes));
    }

    public int[] minOperations(String boxes) {
        char[] chars = boxes.toCharArray();
        int[] res = new int[chars.length];
        for (int i = 0; i < res.length; i++) {
            int num = 0;
            for (int j = 0; j < chars.length; j++) {
                if(i == j) {
                    continue;
                }
                if(chars[j] == '1') {
                    num += Math.abs(j - i);
                }
            }
            res[i] = num;
        }
        return res;
    }
}
