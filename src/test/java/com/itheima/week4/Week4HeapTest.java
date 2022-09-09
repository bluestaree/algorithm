package com.itheima.week4;

import org.junit.Test;

import java.util.*;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-01 08:58
 **/
public class Week4HeapTest {
    @Test
    public void test264丑数II() {
        // int n = 10;
        int n = 1690;
        System.out.println(nthUglyNumber(n));
    }
    
    public int nthUglyNumber(int n) {
        //初始值判断
        if (n == 1) {
            return 1;
        }
        //n>1,需要做 
        int[] arr = {2, 3, 5};
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        set.add(1L);
        heap.add(1L);
        long curr = 1;
        for (int i = 1; i <= n; i++) {
            //次数到了就是需要返回的值
            curr = heap.poll();
            //放入新的
            for (int j : arr) {
                if (set.add(curr * j)) {
                    heap.add(curr * j);
                }
            }
        }
        return (int) curr;
    }
    
    @Test
    public void test面试题1714最小K个数() {
        // int[] arr = {3, 2, 1};
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        // int[] arr = {0, 1, 2, 1};
        int k = 2;
        System.out.println(Arrays.toString(smallestK(arr, k)));
    }
    
    /**
     * 使用的是sort来实现
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }
    
    /**
     * 这个是使用堆的方法来实现
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK2(int[] arr, int k) {
        //初始值判断
        if (arr.length <= k) {
            return arr;
        }
        if (k == 0) {
            return new int[0];
        }
        //其他情况,最小k,需要使用大顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i : arr) {
            if (heap.size() < k) {
                heap.add(i);
            } else {
                if (i < heap.peek()) {
                    //需要进行添加操作
                    heap.poll();
                    heap.add(i);
                }
            }
            
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.remove();
        }
        return res;
    }
    
    @Test
    public void test剑指Offer40最小的k个数() {
        int[] arr = {3, 2, 1};
        // int[] arr = {0, 1, 2, 1};
        int k = 2;
        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));
    }
    
    public int[] getLeastNumbers11(int[] arr, int k) {
        //初始值判断
        if (arr == null) {
            return new int[0];
        }
        int len = arr.length;
        if (len <= k) {
            return arr;
        }
        if (k <= 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.add(i);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.remove();
        }
        return res;
    }
    
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = Arrays.copyOfRange(arr, 0, k);
        return res;
    }
    
    public int[] getLeastNumbers1(int[] arr, int k) {
        //初始值判断
        if (arr == null) {
            return new int[0];
        }
        int len = arr.length;
        if (len <= k) {
            return arr;
        }
        if (k <= 0) {
            return new int[0];
        }
        //len>k的时候
        //将k加入到大顶堆  compare
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                k, (o1, o2) -> o2 - o1 >= 0 ? 1 : -1);
        for (int i = 0; i < k; i++) {
            // System.out.println(arr[i]);
            heap.add(arr[i]);
        }
        // System.out.println(heap);
        //将k+1 到n加入到堆中
        for (int i = k; i < len; i++) {
            int top = heap.element();
            if (arr[i] < top) {
                //移除顶部元素
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        
        int[] res = new int[k];
        //取出所有的heap中的数据,返回
        int i = 0;
        for (Integer integer : heap) {
            res[i++] = integer;
        }
        //
        return res;
        
    }
    
    @Test
    public void test347() {
        int k = 2;
        int[] nums = {1, 1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        //初始值判断
        if (nums == null) {
            return new int[0];
        }
        int len = nums.length;
        if (len <= k) {
            return nums;
        }
        if (k <= 0) {
            return new int[0];
        }
        //len>k>0
        HashMap<Integer, Integer> map = new HashMap<>();
        //存入缓存
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //寻找前k个
        //小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>(k, Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry);
            } else {
                if (entry.getValue() > queue.peek().getValue()) {
                    queue.poll();
                    queue.offer(entry);
                }
            }
        }
        //
        int[] res = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : queue) {
            res[i++] = entry.getKey();
        }
        return res;
    }
}
