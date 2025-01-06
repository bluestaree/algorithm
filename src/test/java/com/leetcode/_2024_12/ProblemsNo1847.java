package com.leetcode._2024_12;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;


/**
 * 1847. 最近的房间
 *
 * @author DHW
 * @date 2024/12/16 9: 54
 * @Version 1.0
*/
public class ProblemsNo1847 {

    @Test
    public void solution() {
        int[][] rooms = new int[][]{new int[]{8,5},new int[]{6,4},new int[]{9,7}};
        int[][] queries = new int[][]{new int[]{8,5},new int[]{6,4},new int[]{9,7}};
        System.out.println("res = " + closestRoom(rooms, queries));
    }

    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int n = queries.length;
        Arrays.sort(rooms, (a,b) -> a[1] - b[1]);
        Integer[] sortIndex = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortIndex[i] = i;
        }
        Arrays.sort(sortIndex, (a,b) -> queries[a][1] - queries[b][1]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] room : rooms) {
            map.put(room[0], 1);
        }
        int[] res = new int[n];
        Arrays.fill(res , -1);
        int i = 0;
        for (Integer j : sortIndex) {
            int prefer = queries[j][0];
            int minValue = queries[j][1];
            while(i < rooms.length && rooms[i][1] < minValue ) {
                map.remove(rooms[i][0]);
                i++;
            }
            Integer p = map.ceilingKey(prefer);
            if(p != null) {
                res[j] = p;
            }
            p = map.floorKey(prefer);
            if(p != null && (res[j] == -1 || res[j] - prefer >= prefer - p)) {
                res[j] = p;
            }
        }
        return res;
    }
}

