package com.itheima.week11.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-01-18 09:50
 **/
public class SortTestDay1 {
    
    @Test
    public void test912() {
        int[] ints = {7, 6, 5, 4, 3, 2, 1};
        //冒泡
        // BubbleSort sort = new BubbleSort();
        //插入排序
        // InsertionSort sort = new InsertionSort();
        //选择排序
        // SelectionSort sort = new SelectionSort();
        //归并
        // MergeSort sort = new MergeSort();
        //快速排序
        // QuickSort sort = new QuickSort();
        //堆排序
        HeapSort sort = new HeapSort();
        //
        System.out.println(Arrays.toString(sort.heapSort(ints)));
    }
    
    @Test
    public void test215数组中的第K个最大元素() {
        int[] ints = {7, 6, 5, 4, 3, 2, 1};
        System.out.println(findKthLargest(ints, 3));
    }
    
    int k215;
    
    public int findKthLargest(int[] nums, int k) {
        // 
        int n = nums.length;
        this.k215 = k;
        quickSort215(nums, 0, n - 1);
        return nums[n - k];
    }
    
    private void quickSort215(int[] nums, int l, int r) {
        //终止条件
        if (l >= r) {
            return;
        }
        //当前层
        int position = partition215(nums, l, r);
        
        //下一层
        int targetIndex = nums.length - k215;
        if (targetIndex > position) {
            quickSort215(nums, position + 1, r);
        } else if (targetIndex < position) {
            quickSort215(nums, l, position - 1);
        }
        
    }
    
    private int partition215(int[] nums, int l, int r) {
        int pivot = nums[l];
        int i = l + 1;
        int j = r;
        while (i <= j) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }
            while (i <= j && nums[j] >= pivot) {
                j--;
            }
            if (j > i) {
                swap215(nums, i, j);
                i++;
                j--;
            }
        }
        //j<i  需要做的事情
        swap215(nums, j, l);
        return j;
    }
    
    private void swap215(int[] nums, int i, int j) {
        if (i != j) {
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
        }
    }
    
    @Test
    public void test面试题1001合并排序的数组() {
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        merge(a, 3, b, 3);
        System.out.println(Arrays.toString(a));
    }
    
    public void merge(int[] A, int m, int[] B, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        for (; ; ) {
            if (j < 0) {
                break;
            }
            if (i < 0) {
                while (j >= 0) {
                    A[k--] = B[j--];
                }
                break;
            }
            if (A[i] <= B[j]) {
                A[k--] = B[j--];
            } else {
                A[k--] = A[i--];
            }
        }
    }
    
    @Test
    public void testOffer剑指Offer51数组中的逆序对() {
        int[] a = {7, 5, 6, 4};
        System.out.println(reversePairs(a));
    }
    
    int[] temp;
    int res = 0;
    
    public int reversePairs(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        temp = new int[len];
        //归并排序
        mergeSort(nums, 0, len - 1);
        return res;
    }
    
    private void mergeSort(int[] nums, int l, int r) {
        //terminal
        if (l >= r) {
            return;
        }
        //拆分
        int mid = l + ((r - l) >> 1);
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        
        //当前层处理
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                //nums[i] > nums[mid+1,j-1]的值,所以这部分就是逆序的量,进行统计
                res = res + (j - (mid + 1));
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        //只有j
        if (i > mid) {
            while (j <= r) {
                temp[k++] = nums[j++];
            }
        } else {
            //只有j
            while (i <= mid) {
                //nums[i] > nums[mid+1,j-1]的值,所以这部分就是逆序的量,进行统计
                res = res + (j - (mid + 1));
                temp[k++] = nums[i++];
            }
        }
        //拷贝
        System.arraycopy(temp, 0, nums, l, r - l + 1);
    }
    
    //==========剑指 Offer 45. 把数组排成最小的数=============
    @Test
    public void testOffer剑指Offer45把数组排成最小的数() {
        // int[] a = {3, 30, 34, 5, 9};
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        // int[] a = {10, 2};
        System.out.println(minNumber(a));
    }
    
    public String minNumber(int[] nums) {
        
        int len = nums.length;
        if (len < 2) {
            return nums[0] + "";
        }
        //>=2
        quickSort(nums, 0, len - 1);
        //拼接字符串,去掉头部的0
        // System.out.println(Arrays.toString(nums));
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
    
    private void quickSort(int[] nums, int l, int r) {
        //结束条件
        if (l >= r) {
            return;
        }
        //当前层
        int position = partition(nums, l, r);
        //左边
        quickSort(nums, l, position - 1);
        //右边
        quickSort(nums, position + 1, r);
    }
    
    private int partition(int[] nums, int l, int r) {
        int povit = nums[l];
        int i = l + 1;
        int j = r;
        for (; ; ) {
            while (i <= j && minThen(nums[i], povit)) {
                i++;
            }
            while (i <= j && !minThen(nums[j], povit)) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, j, l);
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
        }
    }
    
    private boolean minThen(int f, int s) {
        
        String s1 = "" + f + s;
        String s2 = "" + s + f;
        
        // System.out.println("s1: " + s1 + " s2: " + s2 + " compareTo: " + s1.compareTo(s2));
        return s1.compareTo(s2) <= 0;
    }
    
    @Test
    public void testOffertemp() {
        // System.out.println(minThen(2, 3));
        System.out.println('a' + 0);
        System.out.println('z' + 0);
        System.out.println('A' + 0);
        System.out.println('Z' + 0);
    }
    
}
