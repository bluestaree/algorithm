package com.leetcode._2025_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 1656. 设计有序流
 *
 * @author DHW
 * @date 2025/2/24 16:06
 * @Version 1.0
 */
public class ProblemsNo1656 {

    @Test
    public void solution() {
        OrderedStream obj = new OrderedStream(5);
        List<String> param_1 = obj.insert(1, "aaaaa");
        System.out.println("res = " + param_1);
    }

    class OrderedStream {
        int index = 0;
        String[] arr;

        public OrderedStream(int n) {
            arr = new String[n];
        }

        public List<String> insert(int idKey, String value) {
            ArrayList list = new ArrayList<>();
            int ralIndex = idKey - 1;
            arr[ralIndex] = value;
            if (index == ralIndex) {
                while(index < arr.length && arr[index] != null) {
                    list.add(arr[index++]);
                }
            }
            return list;
        }
    }
}
