package com.leetcode._2023_1;

import org.junit.Test;


/**
 * 2180. 统计各位数字之和为偶数的整数个数
 *
 * @author DHW
 * @date 2023/1/6 9:25
 * @Version 1.0
*/
public class ProblemsNo2180 {

    @Test
    public void solution() {
        int num = 30;
        System.out.println("res = " + countEven(num));
    }

    public int countEven(int num) {
        int res = 0;
        for (int i = 2; i <= num; i++) {
            int sum = 0;
            int k = i;
            while(k!=0){
                sum+=k%10;
                k/=10;
            }
            if(sum % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
