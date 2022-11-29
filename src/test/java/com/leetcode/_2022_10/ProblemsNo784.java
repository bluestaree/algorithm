package com.leetcode._2022_10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 784. 字母大小写全排列
 *
 * @author DHW
 * @date 2022/10/30 11:20
 * @Version 1.0
*/
public class ProblemsNo784 {

    @Test
    public void solution() {
        String s = "110";
        List<String> strings = letterCasePermutation(s);
        for (String string : strings) {
            System.out.println("string = " + string);
        }
    }

    public List<String> letterCasePermutation(String s) {
        ArrayList<String> list = new ArrayList<>();
        toFlashBack(list, s.toCharArray(), 0);
        return list;
    }

    private void toFlashBack(List res, char[] chars, int index){
        res.add(new String(chars));
        for (int i = index; i < chars.length; i++) {
            if(chars[i] < 'A') {
                continue;
            } else if(chars[i] >= 'a') {
                chars[i] = (char) (chars[i] - 32);
                toFlashBack(res, chars, i + 1);
                chars[i] = (char) (chars[i] + 32);
            } else {
                chars[i] = (char) (chars[i] + 32);
                toFlashBack(res, chars, i + 1);
                chars[i] = (char) (chars[i] - 32);
            }
        }
    }
}
