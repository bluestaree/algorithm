package com.itheima.week4;

import com.itheima.week4.binary_tree.Node;
import com.itheima.week4.binary_tree.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-09-16 16:36
 **/
public class Week4BinaryTreeTest {
    @Test
    public void test144二叉树的前序遍历() {
        preorderTraversal(null);
    }
    
    ArrayList<Integer> list144 = new ArrayList<>();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        //循环终止条件
        //初始值判断
        if (root == null) {
            return list144;
        }
        //当前处理逻辑
        list144.add(root.val);
        //左子节点
        preorderTraversal(root.left);
        //右子节点
        preorderTraversal(root.right);
        return list144;
    }
    
    /**
     * 使用栈的方式
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        //初始值判断
        if (root == null) {
            return Collections.emptyList();
        }
        //递归查询
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.poll();
            list.add(p.val);
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }
        }
        return list;
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
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        //初始值判断
        if (root == null) {
            return Collections.emptyList();
        }
        //递归查询
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            //左侧入坑
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //右侧
            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                //right !=null
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }
    
    @Test
    public void test94二叉树的中序遍历() {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root));
    }
    
    ArrayList<Integer> list94 = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode now) {
        //终止条件
        if (now == null) {
            return list94;
        }
        //左节点先遍历
        inorderTraversal(now.left);
        //当前节点
        list94.add(now.val);
        //右节点
        inorderTraversal(now.right);
        
        return list94;
    }
    
    @Test
    public void test589N叉树的前序遍历() {
        preorder(null);
    }
    
    ArrayList<Integer> list589 = new ArrayList<>();
    
    public List<Integer> preorder(Node curr) {
        //结束条件
        if (curr == null) {
            return list589;
        }
        //当前层
        list589.add(curr.val);
        //下一层
        for (Node child : curr.children) {
            preorder(child);
        }
        //返回值
        return list589;
    }
    
    @Test
    public void test590N叉树的后序遍历() {
        postorder(null);
    }
    
    ArrayList<Integer> list590 = new ArrayList<>();
    
    public List<Integer> postorder(Node root) {
        //终止条件
        if (root == null) {
            return list590;
        }
        //依次遍历字数
        for (Node child : root.children) {
            postorder(child);
        }
        list590.add(root.val);
        return list590;
    }
    
    @Test
    public void test101对称二叉树() {
        isSymmetric(null);
    }
    
    public boolean isSymmetric(TreeNode root) {
        //初始值判断
        if (root == null) {
            return true;
        }
        //递归求解
        return recursion(root.left, root.right);
    }
    
    @Test
    public void test226翻转二叉树() {
        invertTree(null);
    }
    
    private boolean recursion(TreeNode left, TreeNode right) {
        //终止条件
        if (right == null && left == null) {
            return true;
        } else if (right == null && left != null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        }
        
        //剩下了left和right都有值的情况
        //当前层处理
        if (left.val != right.val) {
            return false;
        } else {
            //下一层处理
            boolean b1 = recursion(left.left, right.right);
            if (!b1) {
                return false;
            }
            boolean b2 = recursion(left.right, right.left);
            if (!b2) {
                return false;
            }
            
        }
        return true;
    }
    
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        recurBianryTree(root);
        return root;
    }
    
    private void recurBianryTree(TreeNode root) {
        //循环终止条件
        if (root == null) {
            return;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        //继续循环
        root.right = left;
        root.left = right;
        recurBianryTree(left);
        recurBianryTree(right);
    }
    
    @Test
    public void test剑指Offer27二叉树的镜像() {
        mirrorTree(null);
    }
    
    public TreeNode mirrorTree(TreeNode curr) {
        //初始条件+终止条件
        if (curr == null) {
            return null;
        }
        //下一层
        mirrorTree(curr.left);
        mirrorTree(curr.right);
        //当前层
        TreeNode tmp = curr.left;
        curr.left = curr.right;
        curr.right = tmp;
        return curr;
    }
    
    @Test
    public void test106从中序与后序遍历序列构造二叉树() {
        // int[] inorder = {9, 3, 15, 20, 7};
        // int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {2, 1};
        int[] postorder = {2, 1};
        // Arrays.binarySearch(inorder, left0, right0 + 1, mid);
        System.out.println(buildTree106(inorder, postorder));
    }
    
    HashMap<Integer, Integer> map106 = new HashMap<>();
    int[] post106;
    
    public TreeNode buildTree106(int[] inorder, int[] postorder) {
        //初始值判断
        if (inorder == null || postorder == null) {
            return null;
        }
        int ilen = inorder.length;
        int plen = postorder.length;
        if (ilen != plen) {
            return null;
        }
        //需要缓存inorder到hashmap中
        for (int i = 0; i < inorder.length; i++) {
            map106.put(inorder[i], i);
        }
        post106 = postorder;
        
        //其他情况
        return recursion(0, ilen - 1, 0, plen - 1);
    }
    
    private TreeNode recursion(int l1, int r1, int l2, int r2) {
        //终止条件
        if (l1 > r1 || l2 > r2) {
            return null;
        }
        int midVal = post106[r2];
        TreeNode midNode = new TreeNode(midVal);
        if (l2 == r2) {
            return midNode;
        }
        //当前层处理
        int mid = map106.get(midVal);
        
        //下一层处理
        //左边
        midNode.left = recursion(l1, mid - 1, l2, l2 + mid - l1 - 1);
        
        //右边
        midNode.right = recursion(mid + 1, r1, l2 + mid - l1, r2 - 1);
        
        //
        return midNode;
    }
}

