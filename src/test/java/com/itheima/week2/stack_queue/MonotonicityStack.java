package com.itheima.week2.stack_queue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-21 16:32
 **/
public class MonotonicityStack {
    @Test
    public void test() {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea1(heights));
    }
    
    public int largestRectangleArea1(int[] heights) {
        //初始值判断
        if (heights == null) {
            return 0;
        }
        int len = heights.length;
        if (len == 1) {
            return heights[0];
        }
        //
        int max = 0;
        
        //
        for (int i = 0; i < len; i++) {
            int h = heights[i];
            
            int l = i;
            while (l > 0) {
                l--;
                if (heights[l] < h) {
                    l++;
                    break;
                }
            }
            int r = i;
            while (r < len - 1) {
                r++;
                if (heights[r] < h) {
                    r--;
                    break;
                }
            }
            int score = (r - l + 1) * h;
            
            max = Math.max(max, score);
        }
        
        return max;
    }
    
    @Test
    public void test02() {
        int[] param = new int[]{6, 10, 3, 7, 4, 4, 12, 5};
        System.out.println(Arrays.toString(getLeftMinNum(param)));
    }
    
    public int[] getLeftMinNum(int[] src) {
        int[] result = new int[src.length];
        //
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < src.length; i++) {
            while (!stack.isEmpty() && src[i] <= stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }
            stack.push(src[i]);
        }
        return result;
    }
    
    @Test
    public void test03() {
        int[] param = new int[]{6, 10, 3, 7, 4, 4, 12, 5};
        System.out.println(Arrays.toString(getLeftMinNumOptimize(param)));
    }
    
    public int[] getLeftMinNumOptimize(int[] src) {
        int[] result = new int[src.length];
        //
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < src.length; i++) {
            while (src[i] <= stack.peek()) {
                stack.pop();
            }
            result[i] = stack.peek();
            stack.push(src[i]);
        }
        return result;
    }
    
}
