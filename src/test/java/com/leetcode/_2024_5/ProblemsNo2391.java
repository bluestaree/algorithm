package com.leetcode._2024_5;

import org.junit.Test;


/**
 * 2391. 收集垃圾的最少总时间
 *
 * @author DHW
 * @date 2024/5/10 8:57
 * @Version 1.0
*/
public class ProblemsNo2391 {

    @Test
    public void solution() {
        String[] garbage = new String[]{"G","P","GP","GG"};
        int[] travel = new int[]{2,4,3};
        System.out.println("res = " + garbageCollection(garbage, travel));
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int[] s = new int[n];
        int res = 0;
        for (int i = 0; i < travel.length; i++) {
            s[i + 1] = s[i] + travel[i];
        }
        boolean[] carts = new boolean[3];
        for (int i = n - 1; i >= 0; i--) {
            res += garbage[i].length();
            if(garbage[i].indexOf('M') >= 0 && !carts[2]) {
                res += s[i];
                carts[2] = true;
            }
            if(garbage[i].indexOf('P') >= 0 && !carts[1]) {
                res += s[i];
                carts[1] = true;
            }
            if(garbage[i].indexOf('G') >= 0&& !carts[0]) {
                res += s[i];
                carts[0] = true;
            }
        }
        return res;
    }


//    public int garbageCollection(String[] garbage, int[] travel) {
//        int n = garbage.length;
//        int[] s = new int[n];
//        for (int i = 0; i < travel.length; i++) {
//            s[i + 1] = s[i] + travel[i];
//        }
//        int[] carts = new int[3];
//        for (int i = n - 1; i >= 0; i--) {
//            for (char c : garbage[i].toCharArray()) {
//                if(c == 'M') {
//                    if(carts[2] == 0) {
//                        carts[2] += s[i];
//                    }
//                    carts[2]++;
//                } else if(c == 'P') {
//                    if(carts[1] == 0) {
//                        carts[1] += s[i];
//                    }
//                    carts[1]++;
//                } else {
//                    if(carts[0] == 0) {
//                        carts[0] += s[i];
//                    }
//                    carts[0]++;
//                }
//            }
//        }
//        return carts[0]+carts[1]+carts[2];
//    }
}

