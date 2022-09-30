package com.leetcode._2022_9;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 1640. 能否连接形成数组
 *
 * @author DHW
 * @date 2022/9/22 9:48
 * @Version 1.0
*/
public class ProblemsNo1640 {

    @Test
    public void solution() {
        int[][] pieces = {{16,18,49}};
        int[] arr = {49,18,16};
        System.out.println("arr = " + canFormArray(arr, pieces));
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        // 记录每个数据的起始整数
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }

        for (int i = 0; i < arr.length;) {
            if(!map.containsKey(arr[i])) {
                return false;
            }
            int[] temp = map.get(arr[i]);
            for (int j = 0; j < temp.length; j++ , i++) {
                if(temp[j] != arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }

}
