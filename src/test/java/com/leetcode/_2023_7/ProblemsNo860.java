package com.leetcode._2023_7;

import org.junit.Test;


/**
 * 860. 柠檬水找零
 *
 * @author DHW
 * @date 2023/7/22 11:08
 * @Version 1.0
*/
public class ProblemsNo860 {

    @Test
    public void solution() {
        int[] bills = new int[]{5,5,10,10,20};
        System.out.println("res = " + lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        int[] accounts = new int[5];
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            accounts[bill / 5] += 1;
            int num = bill - 5;
            for (int j = num / 5; j > 0; j--) {
                if(num <= 0) {
                    break;
                }
                int balance = j * 5;
                if(accounts[j] != 0 && balance <= num) {
                    accounts[j] -= 1;
                    num -= balance;
                    j++;
                }
            }
            if(num != 0){
                return false;
            }

        }
        return true;
    }

}
