package com.leetcode._2023_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 1042. 1042
 *
 * @author DHW
 * @date 2023/4/15 11:19
 * @Version 1.0
*/
public class ProblemsNo1042 {

    @Test
    public void solution() {
        int n = 3;
        int[][] paths = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 1}};
        System.out.println("res = " + gardenNoAdj(n, paths));
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        ArrayList<List<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(new ArrayList());
        }

        for (int i = 0; i < paths.length; i++) {
            int x = paths[i][0];
            int y = paths[i][1];
            arrayList.get(x-1).add(y);
            arrayList.get(y-1).add(x);
        }

        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < arrayList.size(); i++) {
            List<Integer> list = arrayList.get(i);
            int[] flag = new int[n];
            for (int j = 0; j < list.size(); j++) {
                Integer target = list.get(j);
                if(res[target - 1] != 0) {
                    flag[res[target - 1] - 1] = 1;
                }
            }
            for (int k = 0; k < flag.length; k++) {
                if(flag[k] == 0) {
                    res[i] = k + 1;
                    break;
                }
            }
        }
        return res;
    }
}
