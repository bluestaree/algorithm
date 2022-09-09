package com.itheima.week2.queue.queue_703数据流中的第K大元素;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-21 15:24
 **/
public

//
class KthLargest1 {
    
    private int k;
    PriorityQueue<Integer> priorityQueue;
    
    public KthLargest1(int k, int[] nums) {
        this.k = k;
        Comparator<? super Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // System.out.println(o1 + " : " + o2);
                return o1 - o2;
            }
        };
        this.priorityQueue = new PriorityQueue<>(k, comparator);
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            add(val);
        }
        // System.out.println(priorityQueue);
    }
    
    public int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.offer(val);
        } else {
            //要保持前三大小的,其他不要
            if (priorityQueue.element() < val) {
                priorityQueue.poll();
                priorityQueue.offer(val);
            }
        }
        return priorityQueue.element();
    }
}

