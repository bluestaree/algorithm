package com.leetcode._2022_12;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1832. 判断句子是否为全字母句
 *
 * @author DHW
 * @date 2022/12/13 15:03
 * @Version 1.0
*/
public class ProblemsNo1832 {

    @Test
    public void solution() {
        String sentence = "abfetre";
        System.out.println("res = " + checkIfPangram(sentence));
    }

    public boolean checkIfPangram(String sentence) {
        int length = sentence.length();
        if(length < 26) {
            return false;
        }
        char[] chars = sentence.toCharArray();
        Arrays.sort(chars);
        if(chars[0] != 'a' || chars[length-1] != 'z') {
            return false;
        }
        for (int i = 1; i < length; i++) {
            if(chars[i] - chars[i-1] > 1) {
                return false;
            }
        }
        return true;
    }
}
