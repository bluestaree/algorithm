package com.leetcode._2024_5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 2951. 找出峰值
 *
 * @author DHW
 * @date 2024/5/28 9:49
 * @Version 1.0
*/
public class ProblemsNo2951 {

    @Test
    public void solution() {
        int[] mountain = new int[]{1,1,1,4,2,3};
        System.out.println("res = " + findPeaks(mountain));
    }

    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if(mountain[i] > mountain[i-1] && mountain[i] > mountain[i+1]) {
                list.add(i);
                i++;
            }
        }
        return list;
    }
}

