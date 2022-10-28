package com.leetcode._2022_10;

import org.junit.Test;


/**
 * 1822. 数组元素积的符号
 *
 * @author DHW
 * @date 2022/10/27 10:10
 * @Version 1.0
*/
public class ProblemsNo1822 {

    @Test
    public void solution() {
        int[] num = new int[]{-1,-2,-3,-4,3,2,1};
        System.out.println("arr = " + arraySign(num));
    }

    public int arraySign(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if(num == 0) {
                return 0;
            }
            if(num < 0) {
                count++;
            }
        }
        if(count % 2 == 0) {
            return 1;
        }
        return -1;
    }
}