package com.leetcode._2023_3;

import org.junit.Test;


/**
 * 2469. 温度转换
 *
 * @author DHW
 * @date 2023/3/21 11:13
 * @Version 1.0
*/
public class ProblemsNo2469 {

    @Test
    public void solution() {
        double celsius = 0.22;
        System.out.println("res = " + convertTemperature(celsius));
    }

    public double[] convertTemperature(double celsius) {
        double[] doubles = new double[2];
        doubles[0] = celsius + 273.15;
        doubles[1] = celsius * 1.8 + 32;
        return doubles;
    }
}
