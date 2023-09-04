package com.leetcode._2023_8;

import javafx.scene.effect.SepiaTone;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


/**
 * 2682. 找出转圈游戏输家
 *
 * @author DHW
 * @date 2023/8/16 9:07
 * @Version 1.0
*/
public class ProblemsNo2682 {

    @Test
    public void solution() {
        int n = 5;
        int k = 2;
        System.out.println("res = " + circularGameLosers(n, k));
    }

    public int[] circularGameLosers(int n, int k) {
        int[] mark = new int[n];
        for (int i = k, j = 0; mark[j] != 1; i += k) {
            mark[j] = 1;
            j = (j + i) % n;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mark[i] == 0) {
                list.add(i + 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
