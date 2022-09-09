package com.itheima.week14;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: algo_pro
 * @description: 网站链接
 * https://shimo.im/docs/m5kv9b9PKmTKrWqX/read
 * 7整数反转  356134.9%简单
 * 8字符串转换整数 (atoi)  194321.2%中等
 * @author: zhanghz001
 * @create: 2021-11-15 09:28
 **/
public class TopTest1 {
    @Test
    public void test8字符串转换整数() {
        String s;
        s = "words and 987";
        s = "20000000000000000000";
        System.out.println(myAtoi(s));
    }
    
    public int myAtoi(String s) {
        //初始值判断
        if (s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int start = 0;
        while (start < arr.length) {
            //读入字符串并丢弃无用的前导空格
            if (arr[start] == ' ') {
                start++;
            } else {
                break;
            }
        }
        if (start == arr.length) {
            return 0;
        }
        // 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 
        // 确定最终结果是负数还是正数。 
        boolean flag = true;
        if (arr[start] == '-') {
            //负数
            flag = false;
            start++;
        } else if (arr[start] == '+') {
            //正数
            flag = true;
            start++;
        }
        //去掉0开头的数字
        while (start < arr.length && arr[start] == '0') {
            start++;
        }
        if (start == arr.length) {
            return 0;
        }
        // 如果两者都不存在，则假定结果为正。        
        int end = start;
        // 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
        while (end < arr.length && arr[end] >= '0' && arr[end] <= '9') {
            //数字
            end++;
        }
        //end 指向了第一个非字符,或者终点
        if (start == end) {
            return 0;
        } else {
            //读取到数字,并且进行转换
            String s1 = s.substring(start, end);
            // 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。
            // 如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
            long value = 0;
            try {
                value = Long.parseLong(s1);
            } catch (Exception e) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，
            // 使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，
            // 大于 231 − 1 的整数应该被固定为 231 − 1 。
            // 返回整数作为最终结果。
            //  
            if (!flag) {
                value = -value;
            }
            if (Integer.MAX_VALUE < value) {
                return Integer.MAX_VALUE;
            } else if (Integer.MIN_VALUE > value) {
                return Integer.MIN_VALUE;
            } else {
                return (int) value;
            }
        }
        
    }
    
    @Test
    public void test7整数反转() {
        int x = 123;
        reverse(x);
    }
    
    public int reverse(int x) {
        //记下正负
        boolean flag;
        if (x < 0) {
            flag = false;
            x = -x;
        } else {
            flag = true;
        }
        long res = 0;
        //反转
        while (x > 0) {
            int i = x % 10;
            res = 10 * res + i;
            x /= 10;
        }
        //符号加回去
        if (!flag) {
            res = -res;
        }
        //
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) res;
        }
    }
    
    @Test
    public void test13罗马数字转整数() {
        String x = "MCMXCIV";
        System.out.println(romanToInt(x));
    }
    
    public int romanToInt(String s) {
        //初始值判断
        //字符和数值关系
        char[] map = new char[128];
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
        
        //总和
        int sum = 0;
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            char curr = arr[i];
            if (i + 1 < len) {
                char next = arr[i + 1];
                if (curr == 'I' && next == 'V') {
                    sum += 4;
                    i++;
                } else if (curr == 'I' && next == 'X') {
                    
                    sum += 9;
                    i++;
                } else if (curr == 'X' && next == 'L') {
                    sum += 40;
                    i++;
                    
                } else if (curr == 'X' && next == 'C') {
                    sum += 90;
                    i++;
                    
                } else if (curr == 'C' && next == 'D') {
                    
                    sum += 400;
                    i++;
                } else if (curr == 'C' && next == 'M') {
                    sum += 900;
                    i++;
                    
                } else {
                    sum += map[curr];
                }
            } else {
                sum += map[curr];
            }
        }
        return sum;
    }
    
    @Test
    public void test29两数相除() {
        int dividend = 1;
        int divisor = 1;
        System.out.println(divide(dividend, divisor));
    }
    
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        //其他情况,使用快速乘 // TODO: 2021/11/18  
        return 0;
    }
    
    @Test
    public void test34在排序数组中查找元素的第一个和最后一个位置() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
    
    public int[] searchRange(int[] nums, int key) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            
            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return new int[]{findStart(low, mid, key, nums), findEnd(mid, high, key, nums)}; // key found
        }
        return new int[]{-1, -1};  // key not found.
        
    }
    
    private int findStart(int low, int high, int key, int[] nums) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            
            if (midVal < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low; // key found
    }
    
    private int findEnd(int low, int high, int key, int[] nums) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            
            if (midVal > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high; // key found
    }
    
    @Test
    public void test38外观数列() {
        int n = 6;
        System.out.println((countAndSay(n)));
    }
    
    public String countAndSay(int n) {
        String prev = null;
        String curr = "1";
        if (n == 1) {
            return curr;
        }
        //n>1
        for (int i = 2; i <= n; i++) {
            prev = curr;
            curr = getNext(prev);
        }
        return curr;
    }
    
    private String getNext(String prev) {
        char[] arr = prev.toCharArray();
        //生成描述 
        int times = 1;
        char ch = arr[0];
        StringBuilder curr = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ch) {
                times++;
            } else {
                curr.append(times).append(ch);
                ch = arr[i];
                times = 1;
            }
        }
        curr.append(times).append(ch);
        return curr.toString();
    }
    
    @Test
    public void test41缺失的第一个正数() {
        // int[] nums = {1, 2, 0};
        int[] nums = {1, 2, 3};
        System.out.println((firstMissingPositive(nums)));
    }
    
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] target = new boolean[n + 1];
        for (int num : nums) {
            if (num <= n && num > 0) {
                target[num] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!target[i]) {
                return i;
            }
        }
        return n + 1;
    }
    
    @Test
    public void test48旋转图像() {
        int[][] matrix = {{1}};
        rotate(matrix);
    }
    
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int n1 = n - 1;
        int half = n / 2;
        for (int row = 0; row < half; row++) {
            for (int col = row; col < n1 - row; col++) {
                int curr = matrix[row][col];
                int curr90 = matrix[col][n1 - row];
                int curr180 = matrix[n1 - row][n1 - col];
                int curr270 = matrix[n1 - col][row];
                
                matrix[row][col] = curr270;
                matrix[col][n1 - row] = curr;
                matrix[n1 - row][n1 - col] = curr90;
                matrix[n1 - col][row] = curr180;
            }
        }
    }
    
    @Test
    public void test54螺旋矩阵() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        // int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
        //// TODO: 2021/11/22 这题没正确,需要后面看答案 
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int times = Math.min((m + 1) / 2, (n + 1) / 2);
        int col;
        int row;
        int colEnd;
        int rowEnd;
        for (int i = 0; i < times; i++) {
            row = col = i;
            colEnd = (n - 1 - i);
            rowEnd = m - 1 - i;
            if (row == rowEnd && col == colEnd) {
                list.add(matrix[row][col]);
            } else {
                
                while (col < colEnd) {
                    list.add(matrix[row][col]);
                    col++;
                }
                
                while (row < rowEnd) {
                    list.add(matrix[row][col]);
                    row++;
                }
                
                while (col > i) {
                    list.add(matrix[row][col]);
                    col--;
                }
                
                while (row > i) {
                    list.add(matrix[row][col]);
                    row--;
                }
            }
        }
        
        return list;
    }
    
    @Test
    public void test56合并区间() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
    
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 1) {
            return intervals;
        }
        //排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = list.get(list.size() - 1);
            int[] curr = intervals[i];
            if (curr[0] <= prev[1]) {
                //合并
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                //直接加入
                list.add(curr);
            }
        }
        int[][] res = new int[list.size()][2];
        return list.toArray(res);
    }
    
    @Test
    public void test62不同路径() {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }
    
    public int uniquePaths(int m, int n) {
        //dp数组
        int[] dp = new int[n];
        //初始值
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }
        //状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
    
    @Test
    public void test73矩阵置零() {
        
        int[][] matrix = {{0, 2, 3, 0}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    
    public void setZeroes(int[][] matrix) {
        //初始值判断
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        
        //标记对应的行和列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = cols[j] = true;
                }
            }
        }
        
        //替换对应行和列为0
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    @Test
    public void test75颜色分类() {
        
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    public void sortColors(int[] nums) {
        int n = nums.length;
        //初始值判断
        if (n == 1) {
            return;
        }
        int zero = 0;
        int one = 0;
        int two = 0;
        
        //其他情况
        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else if (num == 2) {
                two++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < zero) {
                nums[i] = 0;
            } else if (i >= zero + one) {
                nums[i] = 2;
            } else {
                nums[i] = 1;
            }
        }
        
    }
    
    @Test
    public void test79单词搜索() {
        
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
    
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        boolean[][] set = new boolean[m][n];
        int len = arr.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == arr[0]) {
                    boolean contain = dps(i, j, board, arr, 0, set);
                    if (contain) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dps(int i, int j, char[][] board,
                        char[] word, int deep,
                        boolean[][] set) {
        //结束条件
        
        //当前是匹配结束
        if (deep == word.length) {
            return true;
        }
        
        //边界外
        if (!(0 <= i && i < board.length && 0 <= j && j < board[0].length)) {
            return false;
        }
        
        //不匹配
        if (board[i][j] != word[deep]) {
            return false;
        }
        
        //路径已经走过
        if (set[i][j]) {
            return false;
        }
        
        //记录下走过的路径
        set[i][j] = true;
        
        int[][] direction = new int[][]{
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
        };
        for (int[] direc : direction) {
            int i1 = direc[0] + i;
            int j1 = direc[1] + j;
            
            boolean b = dps(i1, j1, board, word, deep + 1, set);
            if (b) {
                return true;
            }
        }
        
        //回溯恢复
        set[i][j] = false;
        
        return false;
    }
    
    @Test
    public void test91解码方法() {
        String s = "";
        numDecodings(s);
        
    }
    
    public int numDecodings(String s) {
        return 0;
    }
}
