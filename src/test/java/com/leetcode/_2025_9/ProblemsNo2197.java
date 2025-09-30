package com.leetcode._2025_9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 2197. 替换数组中的非互质数
 *
 * @author DHW
 * @date 2025/9/16 9: 31
 * @Version 1.0
*/
public class ProblemsNo2197 {

    @Test
    public void solution() {
        int[] nums =  new int[]{3,3,3,1,2,1,1,2,3,3,4};
        System.out.println("res = " + replaceNonCoprimes(nums));
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
            while(list.size() > 1) {
                int x = list.get(list.size() - 1);
                int y = list.get(list.size() - 2);
                int g = gcd(x,y);
                if(g == 1) {
                    break;
                }
                list.remove(list.size() - 1);
                list.set(list.size() - 1, (int)((long) x * y / g));
            }
        }
        return list;
    }

    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}

