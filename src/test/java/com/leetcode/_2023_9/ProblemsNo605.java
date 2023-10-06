package com.leetcode._2023_9;

import org.junit.Test;


/**
 * 605. 种花问题
 *
 * @author DHW
 * @date 2023/9/29 11:36
 * @Version 1.0
*/
public class ProblemsNo605 {

    @Test
    public void solution() {
        int[] flowerbed = new int[]{0,0,1,0,1};
        int n = 1;
        System.out.println("res = " + canPlaceFlowers(flowerbed, n));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            if(n == 0) {
                return true;
            }
            int preIndex = i + 1;
            int lastIndex = i - 1;
            if(flowerbed[i] == 0) {
                if(lastIndex >= 0 && flowerbed[lastIndex] != 0) {
                    continue;
                }
                if(preIndex < length && flowerbed[preIndex] != 0) {
                    continue;
                }
                n--;
                i++;
            }
        }
        return n == 0;
    }
}
