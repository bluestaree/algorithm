package com.leetcode._2022_10;

import org.junit.Test;


/**
 * 1694. 重新格式化电话号码
 *
 * @author DHW
 * @date 2022/10/1 11:44
 * @Version 1.0
*/
public class ProblemsNo1694 {

    @Test
    public void solution() {
        String s = "1-23-45 6";
        System.out.println("s1 = " + reformatNumber(s));
//        System.out.println("s1 = " + s.replaceAll("[\\s|\\-]", ""));
    }


    public String reformatNumber(String number) {
        String s = number.replaceAll("[\\s|\\-]", "");
        int length = s.length();
        if(length <= 3) {
            return s;
        }
        int endIndex = length;
        if((length % 3) == 1) {
            endIndex = length - 1;
        }
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        int x = 1;
        for (int i = 0; i < endIndex; i++) {
            sb.append(chars[i]);
            if(x % 3 == 0 && i+1 < endIndex) {
                sb.append('-');
            }
            x++;
        }
        if(endIndex != length) {
            sb.append(chars[endIndex]);
            sb.insert(sb.length() -2 , '-');
        }
        return sb.toString();
    }

}
