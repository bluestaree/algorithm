package com.leetcode._2024_4;

import org.junit.Test;

import java.util.*;


/**
 * 705. 设计哈希集合
 *
 * @author DHW
 * @date 2024/4/14 11:14
 * @Version 1.0
*/
public class ProblemsNo705 {

    @Test
    public void solution() {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(2);
        obj.contains(1);
        obj.contains(3);
        obj.add(2);
        obj.contains(2);
        obj.remove(2);
        boolean param_3 = obj.contains(2);
        System.out.println("res = " + param_3);
    }

    class MyHashSet {
        int num = 1000;
        List<LinkedList<Integer>> data;

        public MyHashSet() {
            data = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                data.add(new LinkedList<>());
            }
        }

        public void add(int key) {
            if(contains(key)) {
              return;
            }
            int i = hash(key);
            data.get(i).addFirst(key);
        }

        public void remove(int key) {
            if(!contains(key)) {
                return;
            }
            int i = hash(key);
            data.get(i).remove(Integer.valueOf(key));
        }

        public boolean contains(int key) {
            int i = hash(key);
            Iterator<Integer> iterator = data.get(i).iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if(next == key) {
                   return true;
                }
            }
            return false;
        }

        public int hash(int values) {
            return values % num;
        }

    }

}

