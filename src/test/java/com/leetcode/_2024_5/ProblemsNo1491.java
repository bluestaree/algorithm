package com.leetcode._2024_5;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 1491. 去掉最低工资和最高工资后的工资平均值
 *
 * @author DHW
 * @date 2024/5/3 11:28
 * @Version 1.0
*/
public class ProblemsNo1491 {

    @Test
    public void solution() {
        int[] salary = new int[]{48000,59000,99000,13000,78000,45000,31000,17000,39000,37000,93000,77000,33000,28000,4000,54000,67000,6000,1000,11000};
        System.out.println("res = " + average(salary));
    }

    public double average(int[] salary) {
        Arrays.sort(salary);
        int n = salary.length;
        double num = 0;
        for (int i = 1; i < n - 1; i++) {
            num += salary[i];
        }

        return num / (n - 2);
    }
}

