package com.leetcode._2023_12;

import org.junit.Test;


/**
 * 2660. 保龄球游戏的获胜者
 *
 * @author DHW
 * @date 2023/12/27 9:12
 * @Version 1.0
*/
public class ProblemsNo2660 {

    @Test
    public void solution() {
        int[] player1 = new int[]{6,2,3,1,4,5};
        int[] player2 = new int[]{6,2,3,1,4,5};
        System.out.println("res = " + isWinner(player1, player2));
    }

    public int isWinner(int[] player1, int[] player2) {
        int num1 = getNum(player1);
        int num2 = getNum(player2);
        if(num1 == num2) {
            return 0;
        }
        return num1 > num2 ? 1 : 2;
    }

    private static int getNum(int[] player) {
        int num = 0;
        int f = 0;
        for (int i = 0; i < player.length; i++) {
            if(f != 0) {
                num += (player[i] << 1);
                f--;
            } else {
                num += player[i];
            }
            if(player[i] == 10) {
                f = 2;
            }
        }
        return num;
    }
}

