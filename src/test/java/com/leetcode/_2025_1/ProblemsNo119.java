package com.leetcode._2025_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * 119. 杨辉三角 II
 *
 * @author DHW
 * @date 2025/1/28 10: 28
 * @Version 1.0
 */
public class ProblemsNo119 {

    @Test
    public void solution() {
        System.out.println("c = " + getRow(2));
    }

    private static final List<Integer>[] c = new List[34];

    static {
        c[0] = new ArrayList<>(1);
        c[0].add(0);
        for (int i = 1; i < c.length; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(c[i - 1].get(j - 1) + c[i - 1].get(j));
            }
            row.add(1);
            c[i] = row;
        }
    }

    public List<Integer> getRow(int rowIndex) {
        return c[rowIndex];
    }
}

