package com.leetcode._2023_12;

import org.junit.Test;

import java.util.Calendar;


/**
 * 1185. 一周中的第几天
 *
 * @author DHW
 * @date 2023/12/30 11:49
 * @Version 1.0
*/
public class ProblemsNo1185 {

    @Test
    public void solution() {
        int day = 31;
        int month = 8;
        int year = 2019;
        System.out.println("res = " + dayOfTheWeek(day, month, year));
    }

    public String dayOfTheWeek(int day, int month, int year) {
        String[] format = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        calendar.get(Calendar.DAY_OF_WEEK);
        return format[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }
}

