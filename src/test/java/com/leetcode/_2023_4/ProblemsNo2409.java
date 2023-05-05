package com.leetcode._2023_4;

import org.junit.Test;


/**
 * 2409. 统计共同度过的日子数
 *
 * @author DHW
 * @date 2023/4/17 10:32
 * @Version 1.0
*/
public class ProblemsNo2409 {

    @Test
    public void solution() {
        String arriveAlice = "03-05";
        String leaveAlice = "07-14";
        String arriveBob = "04-14";
        String leaveBob = "09-21";
        System.out.println("res = " + countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] datesOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] prefixSum = new int[13];
        for (int i = 0; i < 12; i++) {
            prefixSum[i + 1] = prefixSum[i] + datesOfMonths[i];
        }

        int arriveAliceDay = calculateDayOfYear(arriveAlice, prefixSum);
        int leaveAliceDay = calculateDayOfYear(leaveAlice, prefixSum);
        int arriveBobDay = calculateDayOfYear(arriveBob, prefixSum);
        int leaveBobDay = calculateDayOfYear(leaveBob, prefixSum);
        return Math.max(0, Math.min(leaveAliceDay, leaveBobDay) - Math.max(arriveAliceDay, arriveBobDay) + 1);
    }

    public int calculateDayOfYear(String day, int[] prefixSum) {
        int month = Integer.parseInt(day.substring(0, 2));
        int date = Integer.parseInt(day.substring(3));
        return prefixSum[month - 1] + date;
    }
}
