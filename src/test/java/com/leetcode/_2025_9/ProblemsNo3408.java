package com.leetcode._2025_9;

import org.junit.Test;

import java.util.*;


/**
 * 3408. 设计任务管理器
 *
 * @author DHW
 * @date 2025/9/18 9: 08
 * @Version 1.0
 */
public class ProblemsNo3408 {

    @Test
    public void solution() {
//        ArrayList<List<Integer>> tasks = new ArrayList<>();
//        ArrayList<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(101);
//        list1.add(10);
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add(2);
//        list2.add(102);
//        list2.add(20);
//        ArrayList<Integer> list3 = new ArrayList<>();
//        list3.add(3);
//        list3.add(103);
//        list3.add(15);
//        tasks.add(list1);
//        tasks.add(list2);
//        tasks.add(list3);
//        TaskManager obj = new TaskManager(tasks);
//        obj.add(4, 104, 5);
//        obj.edit(102, 8);
//        int param_4 = obj.execTop();
//        System.out.println("res = " + param_4);
//        obj.rmv(101);
//        obj.add(5, 105, 15);
//        int param_5 = obj.execTop();
//        System.out.println("res = " + param_5);
        TreeSet<Integer> st = new TreeSet<>((a, b) -> b-a);
        st.add(20);
        st.add(10);
        st.add(15);
        TreeSet<Integer> st1 = new TreeSet<>();
        st1.add(20);
        st1.add(10);
        st1.add(15);
        System.out.println("res = " + st1);
    }

    class TaskManager {

        PriorityQueue<int[]> queue;
        Map<Integer, int[]> map;


        public TaskManager(List<List<Integer>> tasks) {
            queue = new PriorityQueue<>((a, b) -> {
                if(a[0] != b[0]) {
                    return b[0] - a[0];
                }
                return b[1] - a[1];
            });
            map = new HashMap<>();
            for (List<Integer> list : tasks) {
                int userId = list.get(0), taskId = list.get(1), priority = list.get(2);
                map.put(taskId, new int[]{priority, userId});
                queue.offer(new int[]{priority, taskId});
            }
        }

        public void add(int userId, int taskId, int priority) {
            map.put(taskId, new int[]{priority, userId});
            queue.offer(new int[]{priority, taskId});
        }

        public void edit(int taskId, int newPriority) {
            int[] taskInfo = map.get(taskId);
            if(taskInfo != null) {
                taskInfo[0] = newPriority;
                queue.offer(new int[]{newPriority, taskId});
            }
        }

        public void rmv(int taskId) {
            map.remove(taskId);
        }

        public int execTop() {
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int taskId = poll[1];
                int priority = poll[0];
                if(map.containsKey(taskId) && map.get(taskId)[0] == priority) {
                    int userId = map.get(taskId)[1];
                    map.remove(taskId);
                    return userId;
                }
            }
            return -1;
        }
    }
}

