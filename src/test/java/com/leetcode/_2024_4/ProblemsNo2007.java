package com.leetcode._2024_4;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 * 2007. 从双倍数组中还原原数组
 *
 * @author DHW
 * @date 2024/4/18 9:17
 * @Version 1.0
*/
public class ProblemsNo2007 {

    @Test
    public void solution() {
        int[] changed = new int[]{2,1,2,4,2,4};
        System.out.println("res = " + findOriginalArray(changed));
    }

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        int[] empty = new int[0];
        if(n % 2 == 1) {
            return empty;
        }
        int[] res = new int[n / 2];
        Map<Integer, Integer> countMap = new HashMap<>();

        Arrays.sort(changed);
        for (int i = n - 1, j = 0; i >= 0; i--) {
            int num = changed[i] << 1;
            if(countMap.containsKey(num) && countMap.get(num) > 0) {
                res[j] = changed[i];
                j++;
                Integer count = countMap.get(num);
                if(count == 1) {
                    countMap.remove(num);
                } else {
                    countMap.put(num, count - 1);
                }
            } else {
                countMap.put(changed[i], countMap.getOrDefault(changed[i], 0) + 1);
            }
        }
        return countMap.isEmpty() ? res : empty;
    }


}

