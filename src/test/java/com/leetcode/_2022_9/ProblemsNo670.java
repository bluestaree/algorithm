package com.leetcode._2022_9;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 670. 最大交换
 *
 * @author DHW
 * @date 2022/9/13 8:56
 * @Version 1.0
*/
public class ProblemsNo670 {

    @Test
    public void solution() {
        System.out.println("true = " +maximumSwap(1234));
    }

    public int maximumSwap(int num) {
        // 使用hash + 链表
        int index = 0;
        String numStr = Integer.toString(num);
        char[] chars = numStr.toCharArray();
        int len = chars.length;
        if (len == 1) {
            return num;
        }

        changeNum(chars,0);

        return Integer.parseInt(new String(chars));
    }

    private void changeNum(char[] chars, int index) {
        if(index == chars.length) {
            return;
        }
        char max = chars[index];
        int charIndex = index;
        for (int i = index + 1; i < chars.length; i++) {
            if (chars[i] >= max) {
                max = chars[i];
                charIndex = i;
            }
        }
        for (int i = index; i < charIndex; i++) {
            if (chars[i] < max) {
                // 交换位置
                char temp = chars[i];
                chars[i] = max;
                chars[charIndex] = temp;
                return;
            }
        }
        changeNum(chars, charIndex + 1);
        return;
    }

}
