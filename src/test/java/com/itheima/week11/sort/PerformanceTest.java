package com.itheima.week11.sort;

import java.util.Arrays;
import java.util.Random;

public class PerformanceTest {
    static Random random = new Random();
    
    public static int[] genData(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(size + 1);
        }
        return data;
    }
    //10次排序,每次排序的数据是50w,求时间的平均值
    
    public static void main(String[] args) {
        //-----------------------
        long sum = 0L;
        for (int i = 0; i < 10; i++) {
            int[] data = genData(500000);
            long start = System.currentTimeMillis();
            new MergeSort().mergeSort(data);//归并949
            sum += System.currentTimeMillis() - start;
        }
        System.out.println("归并:10次排序-每次50w数据平均耗时为:" + sum / 10L + "毫秒");
        //-----------------------
        sum = 0L;
        for (int i = 0; i < 10; i++) {
            int[] data = genData(500000);
            long start = System.currentTimeMillis();
            //new MergeSort().sortArray(data);//归并949
            new QuickSort().quickSort(data);//快排 1006
            //new HeapSort().sortArray(data);//堆排 1459
            sum += System.currentTimeMillis() - start;
        }
        System.out.println("快速排序:10次排序-每次50w数据平均耗时为:" + sum /
                10L + "毫秒");
        //-----------------------
        sum = 0L;
        for (int i = 0; i < 10; i++) {
            int[] data = genData(500000);
            long start = System.currentTimeMillis();
            //new MergeSort().sortArray(data);//归并949
            //new QuickSort().sortArray(data);//快排 1006
            new HeapSort().heapSort(data);//堆排 1459
            
            sum += System.currentTimeMillis() - start;
        }
        System.out.println("堆排序:10次排序-每次50w数据平均耗时为:" + sum /
                10L + "毫秒");
        //-----------------------
        sum = 0L;
        for (int i = 0; i < 10; i++) {
            int[] data = genData(500000);
            long start = System.currentTimeMillis();
            //new MergeSort().sortArray(data);//归并949
            //new QuickSort().sortArray(data);//快排 1006
            Arrays.sort(data);//堆排 1459
            
            sum += System.currentTimeMillis() - start;
        }
        System.out.println("Arrays.sort:10次排序-每次50w数据平均耗时为:" + sum /
                10L + "毫秒");
        
        //-----------------------
        sum = 0L;
        for (int i = 0; i < 10; i++) {
            int[] data = genData(50000);
            long start = System.currentTimeMillis();
            //new MergeSort().sortArray(data);//归并949
            //new QuickSort().sortArray(data);//快排 1006
            new InsertionSort().insertionSort(data);//堆排 1459
            
            sum += System.currentTimeMillis() - start;
        }
        System.out.println("插入排序:10次排序-每次5w数据平均耗时为:" + sum /
                10L + "毫秒");
        //-----------------------
        sum = 0L;
        for (int i = 0; i < 10; i++) {
            int[] data = genData(50000);
            long start = System.currentTimeMillis();
            //new MergeSort().sortArray(data);//归并949
            //new QuickSort().sortArray(data);//快排 1006
            new BubbleSort().bubbleSort(data);//堆排 1459
            
            sum += System.currentTimeMillis() - start;
        }
        System.out.println("冒泡排序:10次排序-每次5w数据平均耗时为:" + sum /
                10L + "毫秒");
        //-----------------------
        sum = 0L;
        for (int i = 0; i < 10; i++) {
            int[] data = genData(50000);
            long start = System.currentTimeMillis();
            //new MergeSort().sortArray(data);//归并949
            //new QuickSort().sortArray(data);//快排 1006
            new SelectionSort().selectionSort(data);//堆排 1459
            
            sum += System.currentTimeMillis() - start;
        }
        System.out.println("选择排序:10次排序-每次5w数据平均耗时为:" + sum /
                10L + "毫秒");
    }
}
