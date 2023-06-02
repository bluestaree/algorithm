package com.leetcode._2023_5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 2446. 判断两个事件是否存在冲突
 *
 * @author DHW
 * @date 2023/5/17 15:01
 * @Version 1.0
*/
public class ProblemsNo2446 {

    @Test
    public void solution() {
        String[] event1 = new String[]{"01:15","02:00"};
        String[] event2 = new String[]{"01:20","03:00"};
        System.out.println("res = " + haveConflict(event1, event2));
    }

    public boolean haveConflict(String[] event1, String[] event2) {
        String start1 = event1[0];
        int startTime1 = Integer.parseInt(start1.substring(0, 2)) * 60 * 60 + Integer.parseInt(start1.substring(3)) * 60;
        String start2 = event2[0];
        int startTime2 = Integer.parseInt(start2.substring(0, 2)) * 60 * 60 + Integer.parseInt(start2.substring(3)) * 60;

        String end1 = event1[1];
        int endTime1 = Integer.parseInt(end1.substring(0, 2)) * 60 * 60 + Integer.parseInt(end1.substring(3)) * 60;
        String end2 = event2[1];
        int endTime2 = Integer.parseInt(end2.substring(0, 2)) * 60 * 60 + Integer.parseInt(end2.substring(3)) * 60;

        if(startTime1 > startTime2) {
            return endTime2 >= startTime1;
        }

        if(startTime1 < startTime2) {
            return endTime1 >= startTime2;
        }

        return true;
    }
}
