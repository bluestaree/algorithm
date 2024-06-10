package com.leetcode._2024_6;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * 881. 救生艇
 *
 * @author DHW
 * @date 2024/6/10 9:50
 * @Version 1.0
*/
public class ProblemsNo881 {

    @Test
    public void solution() {
        int[] people = new int[]{1,2};
        int limit = 3;
        System.out.println("res = " + numRescueBoats(people, limit));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        for (int i = 0 ,j = people.length -1 ; i <= j; j--) {
            if(people[j] + people[i] <= limit) {
                i++;
            }
            res++;
        }
        return res;
    }
}

