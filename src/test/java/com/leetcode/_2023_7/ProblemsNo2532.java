package com.leetcode._2023_7;

import org.junit.Test;

import java.util.*;


/**
 * 2532. 过桥的时间
 *
 * @author DHW
 * @date 2023/7/7 9:22
 * @Version 1.0
*/
public class ProblemsNo2532 {

    @Test
    public void solution() {
        int n = 10;
        int k = 6;
        int[][] time = new int[][]{new int[]{2,10,5,8}, new int[]{3,5,2,2}
        , new int[]{5,8,10,10}, new int[]{7,8,8,5}, new int[]{5,6,6,10}, new int[]{6,10,6,2}};
        System.out.println("res = " + findCrossingTime( n, k, time));
    }

    public int findCrossingTime(int n, int k, int[][] time) {

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            // 0: 工人标识 1: 当前工人所在时间点，2：0桥左边，2桥右边， 3：效率值 4:手持箱子索引(从1开始)
            int[] marks = new int[5];
            marks[0] = i;
            marks[3] = time[i][0] + time[i][2];
            list.add(marks);
        }

        int nowTime = 0;
        int res = 0;
        while (true) {
            // 该时间点 是否存在需要过桥的人, 按规则 决定过桥的人
            int workerIndex = getCrossWorkerIndex(time, nowTime, list);
            if(workerIndex == -1) {
                // 没有需要过桥的，不存在该情况
                nowTime++;
                continue;
            }
            // 获取当前行动时间点
            int[] ints = list.get(workerIndex);

            // 过桥 处理时间点
            ints[1] += time[ints[0]][ints[2]];
            nowTime += time[ints[0]][ints[2]];

            // 从左到右 / 从右到左
            ints[2] = ints[2] == 0 ? 2 : 0;

            if(ints[4] == 1) {
                // 判断是否最后一个小巷子
                res = ints[1];
                break;
            }

            // 是否卸载箱子
            if(ints[2] == 0 && ints[4] > 0) {
                // 清除标记
                ints[4] = 0;
                // 搬箱子时间
                ints[1] += time[ints[0]][3];
            }

            // 是否搬箱子
            if(n > 0 && ints[2] == 2) {
                // 标记箱子
                ints[4] = n--;
                // 搬箱子时间
                ints[1] += time[ints[0]][1];
            }

//            for (int i = 0; i < list.size(); i++) {
//                nowTime  = Math.min(nowTime, list.get(i)[1]);
//            }

        }
        return res;
    }

    private int getCrossWorkerIndex(int[][] time, int nowTime, List<int[]> list) {
        List<int[]> works = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] marks = list.get(i);
            if(marks[1] <= nowTime) {
                works.add(marks);
            }
        }
        if(works.isEmpty()) {
            return -1;
        }
        works.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] != o2[2]) {
                    return o1[2] - o2[2] > 0 ? -1 : 1;
                }
                if(o1[3] != o2[3]) {
                    return o1[3] - o2[3] > 0 ? -1 :1;
                }
                return o1[0] - o2[0] > 0 ? -1 :1;
            }
        });
//        works.sort((x,y) -> y[2] + y[3] - x[2] - x[3]);
        // 处理 工人 过桥等待时间
        for (int i = 1; i < works.size(); i++) {
            int[] ints = list.get(works.get(i)[0]);
            ints[1] += time[works.get(0)[0]][works.get(0)[2]];
        }
        return works.get(0)[0];


//        List<int[]> leftToRightworks = new ArrayList<>();
//        List<int[]> rightToLeftworks = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            int[] marks = list.get(i);
//            if(marks[1] <= nowTime) {
//                if(marks[2] == 0) {
//                    leftToRightworks.add(marks);
//                } else {
//                    rightToLeftworks.add(marks);
//                }
//
//            }
//        }
//        if(leftToRightworks.isEmpty() && rightToLeftworks.isEmpty()) {
//            return -1;
//        }
//        if(!rightToLeftworks.isEmpty()) {
//            rightToLeftworks.sort((x,y) -> y[3] - x[3]);
//            // 处理 工人 过桥时间
//            for (int i = 1; i < rightToLeftworks.size(); i++) {
//                int[] ints = list.get(rightToLeftworks.get(i)[0]);
//                ints[1] += time[rightToLeftworks.get(0)[0]][rightToLeftworks.get(0)[2]];
//            }
//            for (int i = 0; i < leftToRightworks.size(); i++) {
//                int[] ints = list.get(leftToRightworks.get(i)[0]);
//                ints[1] += time[rightToLeftworks.get(0)[0]][rightToLeftworks.get(0)[2]];
//            }
//            return rightToLeftworks.get(0)[0];
//        }
//
//        leftToRightworks.sort((x,y) -> y[3] - x[3]);
//        // 处理 工人 过桥时间
//        for (int i = 1; i < leftToRightworks.size(); i++) {
//            int[] ints = list.get(leftToRightworks.get(i)[0]);
//            ints[1] += time[leftToRightworks.get(0)[0]][leftToRightworks.get(0)[2]];
//        }
//        return leftToRightworks.get(0)[0];

    }


    public int findCrossingTime1(int n, int k, int[][] time) {

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            // 0: 工人标识 1: 当前工人所在时间点，2：0桥左边，2桥右边， 3：效率值 4:手持箱子索引(从1开始)
            int[] marks = new int[5];
            marks[0] = i;
            marks[3] = time[i][0] + time[i][2] + i;
            list.add(marks);
        }

        int nowTime = 0;
        int res = 0;
        while (true) {
            // 该时间点 是否存在需要过桥的人, 按规则 决定过桥的人
            int workerIndex = getCrossWorkerIndex(time, nowTime, list);
            if(workerIndex == -1) {
                // 没有需要过桥的，不存在该情况
                nowTime++;
                continue;
            }
            // 获取当前行动时间点
            int[] ints = list.get(workerIndex);

            // 过桥 处理时间点
            ints[1] += time[ints[0]][ints[2]];

            // 从左到右 / 从右到左
            ints[2] = ints[2] == 0 ? 2 : 0;

            if(ints[4] == 1) {
                // 判断是否最后一个小巷子
                res = ints[1];
                break;
            }

            // 是否卸载箱子
            if(ints[2] == 0 && ints[4] > 0) {
                // 清除标记
                ints[4] = 0;
                // 搬箱子时间
                ints[1] += time[ints[0]][3];
                nowTime += time[ints[0]][3];
            }

            // 是否搬箱子
            if(n > 0 && ints[2] == 2) {
                // 标记箱子
                ints[4] = n--;
                // 搬箱子时间
                ints[1] += time[ints[0]][1];
                nowTime += time[ints[0]][1];
            }
        }
        return res;
    }

    private int getCrossWorkerIndex1(int[][] time, int nowTime, List<int[]> list) {
        List<int[]> works = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] marks = list.get(i);
            if(marks[1] <= nowTime) {
                works.add(marks);
            }
        }
        if(works.isEmpty()) {
            return -1;
        }
        works.sort((x,y) -> y[2] + y[3] - x[2] - x[3]);
        // 处理 工人 过桥时间
        for (int i = 1; i < works.size(); i++) {
            int[] ints = list.get(works.get(i)[0]);
            ints[1] += time[works.get(0)[0]][works.get(0)[2]];
        }
        return works.get(0)[0];
    }
}
