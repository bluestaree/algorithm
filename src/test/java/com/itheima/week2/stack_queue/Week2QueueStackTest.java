package com.itheima.week2.stack_queue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-09-09 14:51
 **/
public class Week2QueueStackTest {
    
    @Test
    public void test84柱状图中最大的矩形() {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }
    
    public int largestRectangleArea(int[] heights) {
        //初始值判断
        if (heights == null) {
            return 0;
        }
        int len = heights.length;
        if (len == 1) {
            return heights[0];
        }
        int[] h = new int[heights.length + 2];
        System.arraycopy(heights, 0, h, 1, len);
        
        //递增的栈
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        //需要记录max
        int max = 0;
        
        //进行循环 
        for (int i = 1; i < h.length; i++) {
            while (h[stack.peek()] > h[i]) {
                //弹出元素需要计算它的面积
                int hi = stack.pop();
                int area = h[hi] * (i - stack.peek() - 1);
                max = Math.max(max, area);
                
            }
            stack.push(i);
        }
        return max;
        
    }
    
    @Test
    public void test42接雨水() {
        int[] heights = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(trap(heights));
        System.out.println("----------------------");
        heights = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(heights));
    }
    
    //
    public int trap(int[] height) {
        //初始值判断
        if (height == null) {
            return 0;
        }
        int hlen = height.length;
        if (hlen <= 2) {
            return 0;
        }
        //
        int max = 0;
        
        //准备一个单调递增栈
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        //
        
        for (int i = 0; i < hlen; i++) {
            
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                Integer p = stack.pop();
                if (!stack.isEmpty()) {
                    //从i
                    int wid = i - stack.peek() - 1;
                    int hei = Math.min(height[stack.peek()], height[i]) - height[p];
                    int area = wid * hei;
                    System.out.println(area);
                    max += area;
                }
                
            }
            stack.push(i);
        }
        return max;
    }
    
    @Test
    public void test239滑动窗口最大值() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        //初始值判断
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        if (k <= 0) {
            return new int[0];
        }
        //数组小于k,就返回最大值就行了
        if (nums.length <= k) {
            //计算最大的值
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                if (num > max) {
                    max = num;
                }
            }
            return new int[]{max};
        }
        
        //length>k;
        int end = nums.length - k + 1;
        //双端队列,递增队列,其中存储下标,限制k只会越界,不会淘汰旧的值
        Deque<Integer> queue = new LinkedList<>();
        //返回值
        int[] res = new int[end];
        
        //直接放入k个值 
        
        //
        for (int i = 0; i < nums.length; i++) {
            
            while (!queue.isEmpty() && nums[i] >= nums[queue.peek()]) {
                queue.pop();
            }
            //添加新的值
            queue.push(i);
            if (i >= k - 1) {
                //queue长度超过k了,需要进行删除操作
                if (i - queue.peekLast() >= k) {
                    queue.pollLast();
                }
                res[i - k + 1] = nums[queue.peekLast()];
            }
            
        }
        
        return res;
    }
    
    public int[] maxSlidingWindow2(int[] nums, int k) {
        //初始值判断
        
        if (nums == null) {
            return new int[]{};
        }
        int len = nums.length;
        if (len < k) {
            return new int[]{};
        }
        
        //k<len的时候
        int[] result = new int[len - k + 1];
        
        //先求出前k个最大值
        int r = 0;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i >= k - 1) {
                if (i - queue.peekFirst() >= k) {
                    queue.pollFirst();
                }
                result[r++] = nums[queue.peekFirst()];
            }
            
        }
        //
        return result;
    }
    
    public int[] maxSlidingWindow1(int[] nums, int k) {
//特殊判断
        if (nums == null || nums.length < k) {
            return new int[]{};
        }
        //存储结果集
        int[] result = new int[nums.length - k + 1];
        int r = 0;
//利用单调递减队列,队列中存储元素下标
        Deque<Integer> queue = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
//构造单调递减队列,队列中存储的是数组元素的下标
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i >= k - 1) {
//保证后面获取的最大值是在滑动窗口内,只需要用当前下标-队列头(最大值)如果超过窗口大
//                 小则将队列头出队列
                if (i - queue.peekFirst() >= k) {
                    queue.pollFirst();
                }
                result[r++] = nums[queue.peekFirst()];
            }
        }
        return result;
    }
}
