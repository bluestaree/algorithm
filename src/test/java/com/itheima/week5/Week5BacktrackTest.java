package com.itheima.week5;

import org.junit.Test;

import java.util.*;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-06 15:18
 **/
public class Week5BacktrackTest {
    @Test
    public void test46全排列() {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
    
    public List<List<Integer>> permute(int[] nums) {
        //初值判断
        
        //需要进行递归
        List<List<Integer>> res = new ArrayList<>();
        int level = 1;
        //使用了Deque可以 提高撤销选择时候,删除的性能
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] visited = new boolean[nums.length];
        backtrack46(nums, level, visited, path, res);
        return res;
    }
    
    private void backtrack46(int[] nums, int level, boolean[] visited,
                             Deque<Integer> path, List<List<Integer>> res) {
        //终止条件
        if (level > nums.length) {
            //把路径上面的选择保留下来
            res.add(new ArrayList<>(path));
            return;
        }
        
        //回溯递归
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int num = nums[i];
                
                //当前层的选择
                path.offerLast(num);
                visited[i] = true;
                
                //下一层选择
                backtrack46(nums, level + 1, visited, path, res);
                
                //撤销选择
                path.removeLast();
                visited[i] = false;
            }
        }
    }
    
    @Test
    public void test47全排列II() {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        //排序
        Arrays.sort(nums);
        //需要进行回溯递归
        int level = 1;
        ArrayDeque<Integer> path = new ArrayDeque<>();
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        backtrack47(nums, level, visited, path, res);
        return res;
    }
    
    private void backtrack47(int[] nums, int level, boolean[] used,
                             ArrayDeque<Integer> path, List<List<Integer>> res) {
        //终止条件
        if (level > nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        //当前层回溯递归  
        for (int i = 0; i < nums.length; i++) {
            //剪枝1
            if (used[i]) {
                continue;
            }
            //重复元素跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            //选择
            used[i] = true;
            path.addLast(nums[i]);
            
            //下一层递归
            backtrack47(nums, level + 1, used, path, res);
            
            //撤销
            used[i] = false;
            path.removeLast();
            
        }
    }
    
    @Test
    public void test78子集() {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        //需要做回溯递归,将过程中的path存储下来
        int start = 0;
        ArrayDeque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack78(nums, start, path, res);
        return res;
    }
    
    private void backtrack78(int[] nums, int start,
                             ArrayDeque<Integer> path, List<List<Integer>> res) {
        
        //当前层处理
        res.add(new ArrayList<>(path));
        //终止条件
        if (start == nums.length) {
            return;
        }
        //需要回溯
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            //选择
            path.addLast(num);
            //下一层处理
            backtrack78(nums, i + 1, path, res);
            
            //撤销
            path.removeLast();
            
        }
    }
    
    @Test
    public void test90子集II() {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        int start = 0;
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        backtrack90(nums, start, used, path, res);
        return res;
    }
    
    private void backtrack90(int[] nums, int start, boolean[] used,
                             ArrayDeque<Integer> path,
                             List<List<Integer>> res) {
        //需要直接加
        res.add(new ArrayList<>(path));
        
        //终止条件
        if (start == nums.length) {
            return;
        }
        //循环
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            
            //剪枝
            if (i > 0 && nums[i - 1] == num && !used[i - 1]) {
                continue;
            }
            
            //当前层
            path.addLast(num);
            used[i] = true;
            
            //下一层
            backtrack90(nums, i + 1, used, path, res);
            
            //回撤
            path.removeLast();
            used[i] = false;
        }
    }
    
    @Test
    public void test77组合() {
        System.out.println(combine(4, 2));
    }
    
    public List<List<Integer>> combine(int n, int k) {
        
        int start = 1;
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        int level = 0;
        backtrack77(n, k, start, level, path, res);
        return res;
    }
    
    private void backtrack77(int n, int k, int start, int level,
                             ArrayDeque<Integer> path, List<List<Integer>> res) {
        //终止条件
        if (level == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        //回溯+递归
        for (int i = start; i <= n; i++) {
            //选择
            path.addLast(i);
            
            //下一层
            backtrack77(n, k, i + 1, level + 1, path, res);
            
            //撤销
            path.removeLast();
        }
    }
    
    @Test
    public void test17电话号码的字母组合() {
        System.out.println(letterCombinations("23"));
    }
    
    public List<String> letterCombinations(String digits) {
        
        List<String> res = new ArrayList<>();
        //初始值判断
        if (digits == null || digits.length() == 0) {
            return res;
        }
        int level = 0;
        char[] path = new char[digits.length()];
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        //
        backtrack17(digits.toCharArray(), map, level, path, res);
        return res;
    }
    
    private void backtrack17(char[] arr, HashMap<Character, char[]> map,
                             int level, char[] path, List<String> res) {
        //终止条件
        if (level == arr.length) {
            res.add(new String(path));
            return;
        }
        //递归和回溯
        char[] list = map.get(arr[level]);
        for (char c : list) {
            //选择
            path[level] = c;
            
            //下一层
            backtrack17(arr, map, level + 1, path, res);
            
            //撤销
            path[level] = 0;
        }
    }
    
    @Test
    public void test51N皇后() {
        System.out.println(solveNQueens(4));
        System.out.println("---");
        System.out.println(solveNQueens(1));
    }
    
    public List<List<String>> solveNQueens(int n) {
        //初始值判断 n==1  
        int row = 0;
        List<List<String>> res = new ArrayList<>();
        int[] path = new int[n];
        Arrays.fill(path, -1);
        //二进制的横撇捺
        HashSet<Integer> shu = new HashSet<>(n);
        HashSet<Integer> pie = new HashSet<>(n);
        HashSet<Integer> na = new HashSet<>(n);
        
        //
        backtrack51(n, row, shu, pie, na, path, res);
        return res;
        
    }
    
    private void backtrack51(int n, int row, HashSet<Integer> shu, HashSet<Integer> pie,
                             HashSet<Integer> na,
                             int[] path, List<List<String>> res) {
        //终止条件
        if (row == n) {
            //看看效果
            res.add(generate(path, n));
            return;
        }
        //回溯和递归
        for (int i = 0; i < n; i++) {
            //剪枝
            if (shu.contains(i)) {
                continue;
            }
            //需要存储的是row+col
            int rowAddCol = row + i;
            if (pie.contains(rowAddCol)) {
                continue;
            }
            //存储 row-col
            int rowSubCol = row - i;
            if (na.contains(rowSubCol)) {
                continue;
            }
            
            //选择
            shu.add(i);
            pie.add(rowAddCol);
            na.add(rowSubCol);
            path[row] = i;
            
            //下一层  
            backtrack51(n, row + 1, shu, pie, na, path, res);
            
            //撤销
            shu.remove(i);
            pie.remove(rowAddCol);
            na.remove(rowSubCol);
            path[row] = -1;
        }
    }
    
    private List<String> generate(int[] path, int n) {
        List<String> res = new ArrayList<>();
        for (int value : path) {
            char[] c = new char[n];
            Arrays.fill(c, '.');
            c[value] = 'Q';
            res.add(new String(c));
        }
        
        return res;
    }
    
    @Test
    public void test169多数元素() {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
    
    /**
     * 觉得采用分治的方式,不是好的方式还是采用大顶堆吧
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        //是num,num出现次数组成map
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int half = nums.length / 2;
        //这时候需要查询其中value大于len/2的值了
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > half) {
                return entry.getKey();
            }
        }
        //其他
        return 0;
    }
}
