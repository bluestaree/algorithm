package com.leetcode._2022_12;

import org.junit.Test;


/**
 * 1781. 所有子字符串美丽值之和
 *
 * @author DHW
 * @date 2022/12/2 13:54
 * @Version 1.0
*/
public class ProblemsNo1781 {

    @Test
    public void solution() {
        String boxes = "xzvfsppsjfbxdwkqe";
        System.out.println("res = " + beautySum(boxes));
    }

    public int beautySum(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < chars.length - 1; i++) {

            for (int k = 0; k < count.length; k++) {
                count[k] = 0;
            }
            for (int j = i; j < chars.length; j++) {
                int index = chars[j] - 'a';
                count[index] += 1;
                int min = Integer.MAX_VALUE;
                int max = 0;
                for (int x = 0; x < count.length; x++) {
                    if(count[x] !=0 && min > count[x]) {
                        min = count[x];
                    }
                    if(max < count[x]) {
                        max = count[x];
                    }
                }
                if(min == 0) {
                    continue;
                }
                res += (max - min);
            }
        }
        return res;
    }
}
