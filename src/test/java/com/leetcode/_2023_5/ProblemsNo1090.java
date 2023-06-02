package com.leetcode._2023_5;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * 1090. 受标签影响的最大值
 *
 * @author DHW
 * @date 2023/5/23 10:37
 * @Version 1.0
*/
public class ProblemsNo1090 {

    @Test
    public void solution() {
        int[] values = new int[]{3,2,3,2,1};
        int[] labels = new int[]{1,0,2,2,1};
        int numWanted = 2;
        int useLimit = 1;
        System.out.println("res = " + largestValsFromLabels(values, labels, numWanted, useLimit));
    }

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int[][] array = new int[values.length][2];
        for (int i = 0; i < values.length; i++) {
            array[i][0] = values[i];
            array[i][1] = labels[i];
        }
        Arrays.sort(array, (o1, o2) -> o2[0] - o1[0]);
        int res = 0;
        Map<Integer, Integer> useMark = new HashMap<>();
        for (int[] ints : array) {
            Integer mark = useMark.getOrDefault(ints[1], 0);
            if(mark < useLimit){
                res += ints[0];
                useMark.put(ints[1], ++mark);
                numWanted--;
            }
            if(0 == numWanted){
                break;
            }
        }
        return res;
    }
}
