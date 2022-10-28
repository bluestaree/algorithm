package com.leetcode._2022_10;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 769. 最多能完成排序的块
 *
 * @author DHW
 * @date 2022/10/13 9:30
 * @Version 1.0
*/
public class ProblemsNo769 {

    @Test
    public void solution() {
        int[] arr = new int[]{0,1,3,2,4};
        int[] arr1 = new int[]{2,1,0,4,3};
        System.out.println("arr = " + maxChunksToSorted(arr));
    }

    public int maxChunksToSorted1(int[] arr) {
        int partMax = -1;
        int count = 0;
        int max = arr[0];
        int countNum = 0;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                countNum++;
            }
            if(arr[i] < min) {
                min = arr[i];
            }
            if(arr[i] > arr[i-1] && arr[i] > partMax) {
                partMax = arr[i];
                count ++;
                continue;
            }
            if(partMax == arr[i-1]) {
                continue;
            }
            partMax = arr[i-1];
            count ++;
        }
        if(max > arr[arr.length - 1] || min == arr[arr.length - 1]) {
            return 1;
        }
        if(max == arr[arr.length - 1]) {
            return ++count;
        }
        if(countNum == arr.length) {
            return arr.length;
        }
        return count;
    }

    public int maxChunksToSorted(int[] arr) {
        Deque<int[]> queue = new ArrayDeque<>();
        for (int num : arr) {
            int max = num;
            int min = num;
            //处理情况一和情况二，进行块的合并
            while (!queue.isEmpty() && (queue.peekLast()[1] > num || queue.peekLast()[0] > num)) {
                int[] ints = queue.pollLast();
                max = Math.max(max, ints[1]);
                min = Math.min(min, ints[0]);
            }
            queue.addLast(new int[]{min, max});
        }
        return queue.size();
    }

}
