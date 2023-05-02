package com.leetcode._2023_5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 970. 强整数
 *
 * @author DHW
 * @date 2023/5/2 11:21
 * @Version 1.0
*/
public class ProblemsNo970 {

    @Test
    public void solution() {
        int x = 1;
        int y = 1;
        int boun = 1;
        System.out.println("res = " + powerfulIntegers(x, y, boun));
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; j + i <= bound; j *= y) {
                set.add(j + i);
                if(y == 1) {
                    break;
                }
            }
            if(x == 1) {
                break;
            }
        }
        return new ArrayList<>(set);
    }
}
