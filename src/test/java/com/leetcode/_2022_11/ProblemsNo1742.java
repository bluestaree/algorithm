package com.leetcode._2022_11;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


/**
 * 1742. 盒子中小球的最大数量
 *
 * @author DHW
 * @date 2022/11/23 17:24
 * @Version 1.0
*/
public class ProblemsNo1742 {

    @Test
    public void solution() {
        System.out.println("arr = " + countBalls(1, 10));
    }

    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        String s = null;
        int result = 0;
        int key = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            s = i + "";
            char[] chars = s.toCharArray();
            for (int i1 = 0; i1 < chars.length; i1++) {
                int k = (int)chars[i1] - '0';
                key = key + k;
            }
            Integer value = map.getOrDefault(key, 0) + 1;
            map.put(key, value);
            key = 0;
            if(value > result) {
                result = value;
            }
        }
        return result;
    }
}
