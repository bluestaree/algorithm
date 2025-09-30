package com.leetcode._2025_9;

import org.junit.Test;

import java.util.PriorityQueue;


/**
 * 3484. 设计电子表格
 *
 * @author DHW
 * @date 2025/9/19 9: 32
 * @Version 1.0
 */
public class ProblemsNo3484 {

    @Test
    public void solution() {
        Spreadsheet obj = new Spreadsheet(458);
//        obj.setCell("A2", 1);
//        obj.resetCell("A2");
            int param_3 = obj.getValue("=O126+10272");
        System.out.println("res = " + param_3);
    }

    class Spreadsheet {

        int[][] excel;

        public Spreadsheet(int rows) {
            excel = new int[rows][26];
        }

        public void setCell(String cell, int value) {
            int row = parseRow(cell);
            int col = parseCol(cell);
            excel[row][col] = value;
        }

        public void resetCell(String cell) {
            int row = parseRow(cell);
            int col = parseCol(cell);
            excel[row][col] = 0;
        }

        public int getValue(String formula) {
            formula = formula.substring(1);
            String[] split = formula.split("\\+");
            int sum = 0;
            for (String s : split) {
                if(Character.isDigit(s.charAt(0))){
                    sum += Integer.parseInt(s);
                } else {
                    sum += excel[parseRow(s)][parseCol(s)];
                }
            }
            return sum;

        }

        private int parseRow(String cell) {
            return Integer.parseInt(cell.substring(1)) - 1;
        }

        private int parseCol(String cell) {
            char c = cell.charAt(0);
            return c - 'A';
        }
    }
}

