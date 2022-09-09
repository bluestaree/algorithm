package com.itheima.week2.queue.queue_703数据流中的第K大元素;

import java.util.PriorityQueue;

public
//
class KthLargest {
    private PriorityQueue<Integer> queue;
    private int k;
    
    public KthLargest(int k, int[] nums) {
        //优先级
        queue = new PriorityQueue<>(k);
        this.k = k;
        for (int num : nums) {
            add(num);
        }
        
    }
    
    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else
            //如果满了
            if (queue.element() < val) {
                queue.poll();
                queue.offer(val);
            }
        return queue.element();
    }
    
}
