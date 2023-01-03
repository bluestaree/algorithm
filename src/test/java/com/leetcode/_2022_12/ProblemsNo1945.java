package com.leetcode._2022_12;

import org.junit.Test;


/**
 * 1945. 字符串转化后的各位数字之和
 *
 * @author DHW
 * @date 2022/12/15 14:34
 * @Version 1.0
*/
public class ProblemsNo1945 {

    @Test
    public void solution() {
        String s = "leetcode";
        int k = 2;
        System.out.println("res = " + getLucky(s, k));
    }

    public int getLucky(String s, int k) {
        char[] chars = s.toCharArray();
        String nums = "";
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            nums += Integer.toString(chars[i] - 'a' + 1 );
        }
        for (int i = 0; i < k; i++) {
            if(nums.length() == 1) {
                return Integer.parseInt(nums);
            }
            res = 0;
            char[] array = nums.toCharArray();
            for (int j = 0; j < array.length; j++) {
                res += (array[j] - '0');
            }
            nums = Integer.toString(res);
        }
        return res;
    }
}
