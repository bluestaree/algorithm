package com.leetcode._2023_10;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2525. 根据规则将箱子分类
 *
 * @author DHW
 * @date 2023/10/20 9:07
 * @Version 1.0
*/
public class ProblemsNo2525 {

    @Test
    public void solution() {
        int length = 1000; int width = 35;
        int height = 700; int mass = 300;
        System.out.println("res = " + categorizeBox(length, width, height, mass));
    }

    public String categorizeBox(int length, int width, int height, int mass) {
        int targetVolumes = 1000000000;
        int targetLen = 10000;
        boolean isBulky = length >= targetLen || width >= targetLen || height >= targetLen || 1L * length * width * height >= targetVolumes;
        boolean isHeavy = mass >= 100;
        if(isBulky && isHeavy) {
            return "Both";
        } else if(isBulky) {
            return "Bulky";
        } else if(isHeavy){
            return "Heavy";
        }
        return "Neither";
    }
}

