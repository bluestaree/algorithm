package com.itheima.week5.divide_backtrack;

import com.itheima.week4.binary_tree.TreeNode;
import org.junit.Test;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-06 09:27
 */
public class TreeTest {
    
    @Test
    public void test236二叉树的最近公共祖先() {
        lowestCommonAncestor(null, null, null);
    }
    
    /**
     * 这个是属于递归,但是想不到这样的思路,真棒
     *
     * @param curr
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode curr, TreeNode p, TreeNode q) {
        //递归终止条件
        if (curr == null) {
            return curr;
        }
        if (curr == p) {
            return curr;
        }
        if (curr == q) {
            return curr;
        }
        //下一层递归
        TreeNode left = lowestCommonAncestor(curr.left, p, q);
        TreeNode right = lowestCommonAncestor(curr.right, p, q);
        if (left == null && right == null) {
            return null;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            return curr;
        }
    }
    
}


