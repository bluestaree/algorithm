package com.leetcode._2024_9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 2332. 坐上公交的最晚时间
 *
 * @author DHW
 * @date 2024/9/18 9:09
 * @Version 1.0
*/
public class ProblemsNo2332 {

    @Test
    public void solution() {
        int[] buses = new int[]{2,4};
        int[] passengers = new int[]{3,4};
        int capacity = 2;
        System.out.println("res = " + latestTimeCatchTheBus(buses, passengers, capacity));
    }

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int maxTime = buses[buses.length - 1];
        int index = 0;
        for (int time : buses) {
            int limit = capacity + index;
            for (; index < limit; index++) {
                if(index == passengers.length) {
                    if(passengers[index-1] != maxTime) {
                        return maxTime;
                    }
                    break;
                }
                if(passengers[index] > time) {
                    if(maxTime == time && (index == 0 || time != passengers[index-1])) {
                        return maxTime;
                    }
                    break;
                }
            }
        }
        while(index - 2 >= 0 && passengers[index-1] - 1 == passengers[index-2]) {
            index--;
        }
        return passengers[index-1] - 1;
    }
}

