package com.itheima.week4;

import com.itheima.week4.binary_tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-09-17 11:58
 **/
public class Week4BinarySearchTreeTest {
    @Test
    public void test96不同的二叉搜索树() {
        System.out.println(numTrees(3));
    }
    
    HashMap<Integer, Integer> map96 = new HashMap<>();
    
    public int numTrees(int n) {
        //初始值判断
        if (n <= 1) {
            return 1;
        }
        //缓存中获取
        if (map96.containsKey(n)) {
            map96.get(n);
        }
        //当前层处理
        int sum = 0;
        for (int i = 0; i < n; i++) {
            //上一层处理 
            sum += numTrees(i) * numTrees(n - i - 1);
        }
        //
        map96.put(n, sum);
        return sum;
    }
    
    @Test
    public void test95不同的二叉搜索树II() {
        for (TreeNode generateTree : generateTrees(3)) {
            System.out.println(generateTree);
        }
        System.out.println("=====");
        System.out.println(generateTrees(3).size());
    }
    
    public List<TreeNode> generateTrees(int n) {
        
        return recursion95(1, n);
    }
    
    private List<TreeNode> recursion95(int l, int r) {
        //终结条件
        
        List<TreeNode> list = new ArrayList<>();
        if (l > r) {
            list.add(null);
            return list;
        }
        if (l == r) {
            list.add(new TreeNode(l));
            return list;
        }
        //需要循环
        for (int i = l; i <= r; i++) {
            List<TreeNode> rightList = recursion95(i + 1, r);
            List<TreeNode> leftList = recursion95(l, i - 1);
            //循环
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        
        //
        return list;
    }
    
    @Test
    public void test108将有序数组转换为二叉搜索树() {
        
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(sortedArrayToBST(nums));
    }
    
    int[] nums;
    
    public TreeNode sortedArrayToBST(int[] nums) {
        //初始值判断
        if (nums == null || nums.length == 0) {
            return null;
        }
        //接下来需要进行递归
        this.nums = nums;
        return recursion(0, nums.length - 1);
    }
    
    private TreeNode recursion(int l, int r) {
        //终止条件
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        //当前层
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        
        //需要下一层
        node.left = recursion(l, mid - 1);
        node.right = recursion(mid + 1, r);
        
        return node;
    }
    
    @Test
    public void test145二叉树的后序遍历() {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(postorderTraversal(root));
    }
    
    /**
     * 采用的是栈,不用递归
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        //初始值判断
        
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return list;
        }
        TreeNode prev = null;
        
        //root不为空,需要进行遍历
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            // root.left==null
            
            //遍历右子树
            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        
        //返回
        return list;
    }
    
}
