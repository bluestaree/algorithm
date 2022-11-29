package com.leetcode._2022_10;

import org.junit.Test;

import javax.lang.model.SourceVersion;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * 1441. 用栈操作构建数组
 *
 * @author DHW
 * @date 2022/10/15 19:58
 * @Version 1.0
*/
public class ProblemsNo1441 {

    @Test
    public void solution() {
        int[] target = new int[]{1,2,4};
        int n = 4;
        List<String> strings = buildArray(target, n);
        for (String string : strings) {
            System.out.println("string = " + string);
        }
    }

    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> list = new ArrayList<>();
        int x = 0;
        int length = target.length;
        for (int i = 1; i <= n && x < length; i++) {
            if(target[x] == i) {
                list.add("Push");
                x++;
            } else {
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }
}
