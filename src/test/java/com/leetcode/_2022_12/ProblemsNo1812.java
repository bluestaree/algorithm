package com.leetcode._2022_12;

import org.junit.Test;


/**
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 *
 * @author DHW
 * @date 2022/12/8 10:42
 * @Version 1.0
*/
public class ProblemsNo1812 {

    @Test
    public void solution() {
        String boxes = "c7";
        System.out.println("res = " + squareIsWhite(boxes));
    }

    public boolean squareIsWhite(String coordinates) {
        char[] chars = coordinates.toCharArray();
        if(chars[0] % 2 == 0) {
            if(chars[1] % 2 != 0) {
                return true;
            }
        } else {
            if(chars[1] % 2 == 0) {
                return true;
            }
        }
        return false;
    }
}
