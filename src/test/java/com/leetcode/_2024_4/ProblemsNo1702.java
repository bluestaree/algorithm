package com.leetcode._2024_4;

import org.junit.Test;


/**
 * 1702. 修改后的最大二进制字符串
 *
 * @author DHW
 * @date 2024/4/10 9:17
 * @Version 1.0
*/
public class ProblemsNo1702 {

    @Test
    public void solution() {
        String binary = "1000110";
//        String binary = "1111011";
        System.out.println("res = " + maximumBinaryString1(binary));
    }

    public String maximumBinaryString(String binary) {
        char[] array = binary.toCharArray();
        int pre = 0;
        while (pre < array.length && array[pre] == '1') {
            pre++;
        }
        for (int i = array.length - 1; i > pre; i--) {
            if( array[i-1] == '1' && array[i] == '0') {
                int target = i;
                for (int j = i+1; j < array.length && array[j] != '1'; j++) {
                    target = j;
                }
                array[target] = '1';
                array[i-1] = '0';
            }
        }
        for (int i = pre; i < array.length - 1; i++) {
            if(array[i] == '0' && array[i+1] == '0') {
                array[i] = '1';
                array[i+1] = '0';
            }
        }
        return new String(array);
    }

    public String maximumBinaryString1(String binary) {
        int i = binary.indexOf('0');
        if (i < 0) { // binary 全是 '1'
            return binary;
        }
        char[] s = binary.toCharArray();
        int cnt1 = 0;
        for (i++; i < s.length; i++) {
            cnt1 += s[i] - '0'; // 统计 [i, n-1] 中 '1' 的个数
        }
        StringBuffer buffer = new StringBuffer();
        for (int j = 0; j < s.length - 1 - cnt1; j++) {
            buffer.append("1");
        }
        buffer.append("0");
        for (int j = 0; j < cnt1; j++) {
            buffer.append("1");
        }
        return buffer.toString();
    }

}

