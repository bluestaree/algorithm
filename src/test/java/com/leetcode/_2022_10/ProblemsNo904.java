package com.leetcode._2022_10;

import org.junit.Test;

import java.util.HashSet;


/**
 * 904. 水果成篮
 *
 * @author DHW
 * @date 2022/10/12 9:23
 * @Version 1.0
*/
public class ProblemsNo904 {

    @Test
    public void solution() {

//        int[] fruits = new int[]{0,1,0,6,6,0,2};
        int[] fruits = new int[]{5,0,0,7,0,7,2,7};
        System.out.println("nums = " + totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {
        int length = fruits.length;
        if(length == 0 || length == 1 || length == 2) {
            return length;
        }

        int numA = fruits[0];
        int numB = -1;
        int count = 1;
        int result = 0;
        for (int i = 1; i < length; i++) {
            if(fruits[i] == numA || fruits[i] == numB) {
                count ++;
            } else if(numB == -1) {
                numB = fruits[i];
                count ++;
            } else {
                if(length - i < count) {
                    break;
                }
                result = Math.max(result, count);
                count = 1;
                numB = -1;
                for (int j = i - 1; j >= 0; j--) {
                    if(fruits[j] != fruits[j-1]) {
                        numA = fruits[j];
                        i = j;
                        break;
                    }
                }
            }
        }
        result = Math.max(result, count);
        return result;
    }
}
