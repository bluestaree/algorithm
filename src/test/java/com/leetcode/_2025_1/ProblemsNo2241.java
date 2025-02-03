package com.leetcode._2025_1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;


/**
 * 2241. 设计一个 ATM 机器
 *
 * @author DHW
 * @date 2025/1/5 10: 51
 * @Version 1.0
 */
public class ProblemsNo2241 {

    @Test
    public void solution() {
        ATM obj = new ATM();
        obj.deposit(new int[]{0,0,1,2,1});
        int[] param_2 = obj.withdraw(600);
        obj.deposit(new int[]{0,1,0,1,1});
        int[] param_3 = obj.withdraw(600);
        int[] param_4 = obj.withdraw(550);
    }

    class ATM {

        private int[] price = new int[]{20, 50, 100, 200, 500};
        private long[] count= new long[5];

        public ATM() {

        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < banknotesCount.length; i++) {
                count[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] num = new int[5];
            long[] cache = Arrays.copyOf(count, 5);
            for (int i = 4; i >= 0; i--) {
                if(amount == 0) {
                    break;
                }
                while(cache[i] > 0 && amount >= price[i]) {
                    int maxNum = amount / price[i];
                    long realNum = Math.min(cache[i], maxNum);
                    num[i] += realNum;
                    cache[i] -= realNum;
                    amount -= (price[i] * realNum);
                }
            }
            if(amount > 0) {
                return new int[]{-1};
            }
            count = cache;
            return num;
        }
    }
}

