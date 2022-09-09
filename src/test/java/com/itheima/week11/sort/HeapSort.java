package com.itheima.week11.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-01-21 09:22
 **/
public class HeapSort {
    
    @Test
    public void testHeapSort() {
        
        int[] data = new int[]{5, 2, 6, 5, 9, 0, 3};
        System.out.println("排序前:" + Arrays.toString(data));
        // heapSort(data);
        heapSortReview(data);
        System.out.println("排序后:" + Arrays.toString(data));
    }
    
    public int[] heapSortReview(int[] nums) {
        //初始值判断
        int n = nums.length;
        if (n < 2) {
            return nums;
        }
        //构建大顶堆
        toMaxHeap(nums);
        
        //需要更换第一个元素和最后一个(会变)交换,然后再大顶堆化
        for (int i = n - 1; i > 0; i--) {
            //交换
            swap1(nums, i, 0);
            //堆化
            maxIfDown1(nums, 0, i - 1);
        }
        return nums;
    }
    
    private void toMaxHeap(int[] nums) {
        int n = nums.length;
        for (int i = ((n - 2) >> 1); i >= 0; i--) {
            //为了能使用从上到下的堆化调整,我们从倒数第二层最后一个元素开始进行调整
            maxIfDown1(nums, i, n - 1);
        }
    }
    
    private void maxIfDown1(int[] nums, int i, int end) {
        
        int left = i * 2 + 1;
        //终止条件
        if (left > end) {
            return;
        }
        
        //当前层处理
        int right = i * 2 + 2;
        if (right <= end) {
            //n为奇数,就都有左右节点
            //左右节点都有
            int large = i;
            if (nums[large] < nums[left]) {
                large = left;
            }
            if (nums[large] < nums[right]) {
                large = right;
            }
            if (large != i) {
                //相同的不换
                swap1(nums, large, i);
                //下一层处理
                maxIfDown1(nums, large, end);
            }
            
        } else if (left <= end) {
            //说明只有左节点,没有右节点
            int large = i;
            if (nums[large] < nums[left]) {
                large = left;
            }
            //相同的不换
            swap1(nums, large, i);
        }
        
    }
    
    private void swap1(int[] nums, int i, int j) {
        if (i != j) {
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
        }
    }
    
    /**
     * 堆排序
     *
     * @param nums
     * @return
     */
    public int[] heapSort(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return nums;
        }
        //构造大顶堆
        buildMaxHeap(nums);
        /*
            将堆顶元素和堆最后一个元素交换,有序数据多了一个,堆中数据少一个,
            然后针对交换过来的堆顶元素进行堆化调整
            依次操作知道堆中只剩一个元素(只需进行len-1 次交换),怎整体数据有序
            */
        //堆排序 
        for (int i = len - 1; i > 0; i--) {
            //交换最大的元素到最后
            swap(nums, i, 0);
            //对 i-1进行堆化
            maxIfDown(nums, 0, i - 1);
            
        }
        return nums;
    }
    
    //step2:针对nums构建大顶堆
    private void buildMaxHeap(int[] nums) {
        int len = nums.length;
        int max = len / 2 - 1;
        for (int i = max; i >= 0; i--) {
            maxIfDown(nums, i, len - 1);
        }
    }
    
    //step1:在区间[start,end]进行从到到下的堆化调整
    private void maxIfDown(int[] nums, int start, int end) {
        while (start <= (end - 1) >>> 1) {
            int largeIdx = start;
            int left = 2 * start + 1;
            //找自己,左孩子,右孩子中的最大值替换自己
            if (left <= end && nums[largeIdx] < nums[left]) {
                largeIdx = left;
            }
            int right = 2 * start + 2;
            if (right <= end && nums[largeIdx] < nums[right]) {
                largeIdx = right;
            }
            if (start == largeIdx) {
                //结束了
                break;
            } else {
                //如果最大值来自左右孩子,交换
                swap(nums, start, largeIdx);
                start = largeIdx;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
        }
    }
    
}
