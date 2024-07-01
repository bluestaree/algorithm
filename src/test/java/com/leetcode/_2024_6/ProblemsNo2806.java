package com.leetcode._2024_6;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 2806. 取整购买后的账户余额
 *
 * @author DHW
 * @date 2024/6/12 9:56
 * @Version 1.0
*/
public class ProblemsNo2806 {

    @Test
    public void solution() {
        int purchaseAmount = 2;
        System.out.println("res = " + accountBalanceAfterPurchase(purchaseAmount));
    }

    public int accountBalanceAfterPurchase(int purchaseAmount) {
//        int num = purchaseAmount / 10;
//        int d = purchaseAmount % 10 >= 5 ? 1 : 0;
//        return 100 - (num+d) * 10;
        return 100 - ((purchaseAmount + 5) / 10) * 10;
    }
}

