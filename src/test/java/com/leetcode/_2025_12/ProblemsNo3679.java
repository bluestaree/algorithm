package com.leetcode._2025_12;

import org.junit.Test;

import java.util.HashMap;


/**
 * 3679. 使库存平衡的最少丢弃次数
 *
 * @author DHW
 * @date 2025/12/8 8: 55
 * @Version 1.0
*/
public class ProblemsNo3679 {

    @Test
    public void solution() {
        int[] arrivals =  new int[]{1,2,1,3,1};
        int w = 4;
        int m = 2;
        System.out.println("res = " + minArrivalsToDiscard(arrivals, w, m));
    }

    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arrivals.length; i++) {
            Integer num = map.getOrDefault(arrivals[i], 0);
            if(num == m) {
                arrivals[i] = 0;
                ans++;
            } else {
                map.put(arrivals[i], num + 1);
            }
            int l = i - w + 1;
            if( l >= 0) {
                map.merge(arrivals[l], -1, Integer::sum);
            }
        }
        return ans;
    }
}

