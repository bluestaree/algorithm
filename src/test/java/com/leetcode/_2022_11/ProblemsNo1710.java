package com.leetcode._2022_11;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;


/**
 * 1662. 卡车上的最大单元数
 *
 * @author DHW
 * @date 2022/11/15 14:07
 * @Version 1.0
*/
public class ProblemsNo1710 {

    @Test
    public void solution() {
        int[][] boxTypes = new int[][]{new int[]{2,1},new int[]{4,4}
        ,new int[]{3,1},new int[]{4,1},new int[]{2,4},new int[]{3,4}
        ,new int[]{1,3},new int[]{4,3},new int[]{5,3},new int[]{5,3}};
        int truckSize = 13;
        System.out.println("arr = " + maximumUnits(boxTypes, truckSize));
    }

    public int maximumUnits1(int[][] boxTypes, int truckSize) {
        int result = 0;
        Arrays.sort(boxTypes, Comparator.comparingInt(o -> o[1]));
        for (int i = boxTypes.length - 1; i >= 0; i--) {
            if (truckSize > boxTypes[i][0]) {
                result += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                result += truckSize * boxTypes[i][1];
                return result;
            }
        }
        return result;
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int num = 0;
        Box[] boxes = new Box[boxTypes.length];
        for (int i = 0; i < boxTypes.length; i++) {
            int[] boxInfo = boxTypes[i];
            Box box = new Box(boxInfo[0], boxInfo[1]);
            boxes[i] = box;
        }
        Arrays.sort(boxes, (o1, o2) -> o2.boxVolume - o1.boxVolume);

        for (int i = 0; i < boxes.length; i++) {
            Box box = boxes[i];
            Integer boxVolume = box.getBoxVolume();
            Integer boxNum = box.getBoxNum();
            if(truckSize - boxNum <= 0) {
                num += truckSize * boxVolume;
                return num;
            }
            num += boxNum * boxVolume;
            truckSize = truckSize - boxNum;
        }
        return num;
    }

    class Box {
        private int boxNum;
        private int boxVolume;

        public Box(int boxNum, int boxVolume) {
            this.boxNum = boxNum;
            this.boxVolume = boxVolume;
        }

        public int getBoxNum() {
            return boxNum;
        }

        public void setBoxNum(int boxNum) {
            this.boxNum = boxNum;
        }

        public int getBoxVolume() {
            return boxVolume;
        }

        public void setBoxVolume(int boxVolume) {
            this.boxVolume = boxVolume;
        }
    }
}
