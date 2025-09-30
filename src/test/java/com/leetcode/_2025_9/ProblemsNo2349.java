package com.leetcode._2025_9;

import org.junit.Test;

import javax.lang.model.element.VariableElement;
import java.util.HashMap;
import java.util.TreeSet;


/**
 * 2349. 设计数字容器系统
 *
 * @author DHW
 * @date 2025/9/17 9: 06
 * @Version 1.0
 */
public class ProblemsNo2349 {

    @Test
    public void solution() {
        NumberContainers obj = new NumberContainers();
        obj.change(2, 10);
        obj.change(1, 10);
        obj.change(3, 10);
        obj.change(5, 10);
        int param_2 = obj.find(10);
        obj.change(1, 20);
        int param_3 = obj.find(10);
        System.out.println("res = " + param_2);
    }

    class NumberContainers {
        HashMap<Integer, Integer> imap;
        HashMap<Integer, TreeSet<Integer>> map;

        public NumberContainers() {
            imap = new HashMap<>();
            map = new HashMap<>();
        }

        public void change(int index, int number) {
            if(imap.containsKey(index)) {
                Integer old = imap.get(index);
                map.get(old).remove(index);
            }
            imap.put(index, number);
            TreeSet<Integer> set = map.getOrDefault(number, new TreeSet<>());
            set.add(index);
            map.put(number, set);
        }

        public int find(int number) {
            TreeSet<Integer> set = map.get(number);
            return set == null || set.isEmpty() ? -1 : set.first();
        }
    }
}

