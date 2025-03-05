package com.leetcode._2025_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 1287. 有序数组中出现次数超过25%的元素
 *
 * @author DHW
 * @date 2025/2/5 8: 52
 * @Version 1.0
*/
public class ProblemsNo1287 {

    @Test
    public void solution() {
        int[] arr = new int[]{1,2,2,6,6,6,6,7,10};
        System.out.println("res = " + findSpecialInteger(arr));
    }

    public int findSpecialInteger(int[] arr) {
        int len = arr.length / 4;
        for(int i = 0; i + len < arr.length; i++){
            if(arr[i] == arr[i + len]){
                return arr[i];
            }
        }
        return arr[0];
    }
}

