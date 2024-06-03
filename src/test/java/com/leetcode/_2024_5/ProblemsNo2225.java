package com.leetcode._2024_5;

import org.junit.Test;

import java.util.*;


/**
 * 2225. 找出输掉零场或一场比赛的玩家
 *
 * @author DHW
 * @date 2024/5/22 8:43
 * @Version 1.0
*/
public class ProblemsNo2225 {

    @Test
    public void solution() {
        int[][] matches = new int[][]{new int[]{2,3},new int[]{1,3},new int[]{5,4},new int[]{6,4}};
        System.out.println("res = " + findWinners(matches));
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            if(!map.containsKey(match[0])) {
                map.put(match[0], 0);
            }
            map.merge(match[1], 1, Integer::sum);
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int i = entry.getValue();
            if(i < 2) {
                res.get(i).add(entry.getKey());
            }
        }
        Collections.sort(res.get(0));
        Collections.sort(res.get(1));
        return res;
    }
}

