package com.leetcode._2022_12;

import org.junit.Test;


/**
 * 1780. 判断一个数字是否可以表示成三的幂的和
 *
 * @author DHW
 * @date 2022/12/9 9:26
 * @Version 1.0
*/
public class ProblemsNo1780 {

    @Test
    public void solution() {
        int n = 91;
        System.out.println("res = " + checkPowersOfThree(n));
    }

    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 0 || n % 3 == 1) n = n / 3; // 满足三进制
            else return false; // 不满足三进制，返回false
        }
        return true;
    }
}
