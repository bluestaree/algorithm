package com.leetcode._2023_2;

import org.junit.Test;

import java.util.HashMap;


/**
 * 1138. 字母板上的路径
 *
 * @author DHW
 * @date 2023/2/12 10:47
 * @Version 1.0
*/
public class ProblemsNo1138 {

    @Test
    public void solution() {
        String target = "zdz";
        System.out.println("res = " + alphabetBoardPath(target));
    }

    public String alphabetBoardPath(String target) {
        HashMap<Character, int[]> map = new HashMap<>();
        int[][] marks = new int[6][5];
        String[] board = new String[]{"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                marks[i][j] = 1;
                map.put(chars[j], new int[]{i, j});
            }
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = target.toCharArray();
        int poiX = 0;
        int poiY = 0;
        for (int i = 0; i < chars.length; i++) {
            int[] pois = map.get(chars[i]);
            int x = pois[0];
            int y = pois[1];
            while(poiX != x || poiY != y) {
                if(x > poiX && marks[poiX+1][poiY] == 1) {
                    poiX++;
                    sb.append("D");
                    continue;
                }
                if(x < poiX && marks[poiX - 1][poiY] == 1) {
                    poiX--;
                    sb.append("U");
                    continue;
                }
                if(y > poiY && marks[poiX][poiY + 1] == 1) {
                    poiY++;
                    sb.append("R");
                    continue;
                }
                if(y < poiY && marks[poiX][poiY - 1] == 1) {
                    poiY--;
                    sb.append("L");
                    continue;
                }
            }
            sb.append("!");
        }
        return sb.toString();
    }
}
