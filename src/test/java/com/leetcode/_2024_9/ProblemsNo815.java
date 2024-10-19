package com.leetcode._2024_9;

import org.junit.Test;

import java.util.*;


/**
 * 815. 公交路线
 *
 * @author DHW
 * @date 2024/9/17 11:08
 * @Version 1.0
*/
public class ProblemsNo815 {

    @Test
    public void solution() {
        int[][] points = new int[][]{new int[]{2},new int[]{2,8}};
        int source = 8;
        int target = 2;
        System.out.println("res = " + numBusesToDestination(points, source, target));
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j : routes[i]) {
                ArrayList list = map.getOrDefault(j, new ArrayList());
                list.add(i);
                map.put(j, list);
            }
        }

        if (!map.containsKey(source) || !map.containsKey(target)) {
            return -1;
        }

        // 初始化队列和访问集合
        Deque<int[]> deque = new ArrayDeque<>();
        Set<Integer> visBus = new HashSet<>();
        Set<Integer> visStop = new HashSet<>();
        deque.offer(new int[] {source, 0});
        visStop.add(source);

        while(!deque.isEmpty()) {
            int[] poll = deque.poll();
            int stop = poll[0];
            int count = poll[1];

            if(stop == target) {
                return count;
            }

            for (Integer bus : map.get(stop)) {
                if(visBus.add(bus)) {
                    for (int nextStop : routes[bus]) {
                        if(visStop.add(nextStop)) {
                            deque.offer(new int[] {nextStop, count+1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}

