package com.leetcode._2023_5;

import org.junit.Test;


/**
 * 2451. 差值数组不同的字符串
 *
 * @author DHW
 * @date 2023/5/25 11:14
 * @Version 1.0
*/
public class ProblemsNo2451 {

    @Test
    public void solution() {
        String[] words = new String[]{"ddd","poo","baa","onn"};
        System.out.println("res = " + oddString(words));
    }

    public String oddString(String[] words) {
        boolean mark = false;
        int[] num = new int[words[0].length()-1];
        char[] array = words[0].toCharArray();
        for (int j = 0; j < array.length - 1; j++) {
            num[j] = array[j + 1] - array[j];
        }

        int firstNum = 1;
        int secondNum = 0;
        int index = 0;
        for (int i = 1; i < words.length; i++) {
            mark = false;
            if(index != 0) {
                if(firstNum > 1) {
                    return words[index];
                }
                if(secondNum > 1) {
                    return words[0];
                }
            }
            String word = words[i];
            char[] chars = word.toCharArray();
            for (int j = 0; j < chars.length - 1; j++) {
                int count = chars[j + 1] - chars[j];
                if(num[j] != count) {
                    index = i;
                    secondNum++;
                    mark = true;
                    break;
                }
            }
            if(!mark) {
                firstNum++;
            }
        }
        if(firstNum > 1) {
            return words[index];
        }
        return words[0];
    }
}
