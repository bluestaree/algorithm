package com.leetcode._2023_11;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2300. 咒语和药水的成功对数
 *
 * @author DHW
 * @date 2023/11/10 10:26
 * @Version 1.0
*/
public class ProblemsNo2300 {

    @Test
    public void solution() {
        int[] spells = new int[]{15};
        int[] potions = new int[]{1,2,3,4,5};
        long success = 600;
        System.out.println("res = " + successfulPairs(spells, potions, success));
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int length = spells.length;
        int[] res = new int[length];
        Arrays.sort(potions);
        for (int i = 0; i < length; i++) {
            int index = getFirstIndex(spells[i], success, potions, 0 , potions.length - 1);
            res[i] = potions.length - index - 1;
        }
        return res;
    }
    private int getFirstIndex(long num, long success, int[] potions, int left, int right) {
        if(left > right) {
            return right;
        }
        int mid = (right + left) >> 1;
        long res = num * potions[mid];
        if(res >= success) {
            right = mid - 1;
        } else if(res < success) {
            left = mid + 1;
        }
        return getFirstIndex(num, success, potions, left, right);
    }

}

