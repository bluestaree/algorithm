package com.itheima.week4.binary_search_tree;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-30 10:56
 **/
public class BinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        public int getVal() {
            return this.val;
        }
        
        public TreeNode(int val) {
            this.val = val;
        }
        
        public TreeNode(TreeNode left, int val, TreeNode right) {
            this.left = left;
            this.val = val;
            this.right = right;
        }
    }
    
    private TreeNode root;
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
        
    }
    
    private void inOrder(TreeNode root, StringBuilder sb) {
        //递归结束条件
        if (root == null) {
            return;
        }
        //递归过程
        inOrder(root.left, sb);
        //中
        sb.append(root.val).append("->");
        //右
        inOrder(root.right, sb);
        
    }
    //添加
    
    public boolean add(int val) {
        
        //如果root 为空
        if (root == null) {
            root = new TreeNode(val);
            return true;
        }
        
        //如果root 不为空
        TreeNode curr = root;
        while (true) {
            if (val > curr.val) {
                //到右子树上
                if (curr.right == null) {
                    //val到右中
                    curr.right = new TreeNode(val);
                    return true;
                } else {
                    curr = curr.right;
                }
            } else if (val < curr.val) {
                //到左子树上
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    return true;
                } else {
                    curr = curr.left;
                }
            } else {
                //和当前节点冲突了
                return false;
            }
        }
    }
    
    public TreeNode get(int val) {
        TreeNode curr = root;
        
        while (curr != null) {
            if (curr.val == val) {
                return curr;
            } else if (curr.val > val) {
                //左中找
                curr = curr.left;
            } else {
                //右中找
                curr = curr.right;
            }
        }
        return null;
    }
    
    //删除
    public void remove(int val) {
        
        TreeNode del_p = null;
        TreeNode del = root;
        
        while (del != null) {
            if (del.val > val) {
                //左中找
                del_p = del;
                del = del.left;
            } else if (del.val < val) {
                //右中找
                del_p = del;
                del = del.right;
            } else {
                break;
            }
        }
        //找到了
        if (del == null) {
            return;
        }
        if (del_p == null) {
            del = null;
            return;
        }
        //del_p 要指向需要指向的东西
        //右子树开始找,不断找最左侧的节点
        if (del.left != null && del.right != null) {
            //都不为null,找到右子树最小的为此节点
            TreeNode min_p = del;
            TreeNode min = del.right;
            while (min.left != null) {
                min_p = min;
                min = min.left;
            }
            //
            del.val = min.val;
            //
            del = min;
            del_p = min_p;
            
        }
        
        //
        TreeNode del_child = null;
        if (del.left != null) {
            del_child = del.left;
        } else if (del.right != null) {
            del_child = del.right;
        }
        
        //执行删除
        
        if (del_p.right == del) {
            del_p.right = del_child;
        } else if (del_p.left == del) {
            del_p.left = del_child;
        }
        del.left = null;
        del.right = null;
    }
    
    public TreeNode getMax() {
        if (root == null) {
            return null;
        }
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }
    
    public TreeNode getMin() {
        if (root == null) {
            return null;
        }
        TreeNode curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}
