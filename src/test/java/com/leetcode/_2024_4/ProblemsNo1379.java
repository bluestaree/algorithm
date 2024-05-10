package com.leetcode._2024_4;

import com.leetcode._2024_2.ProblemsNo2641;
import org.junit.Test;


/**
 * 1379. 找出克隆二叉树中的相同节点
 *
 * @author DHW
 * @date 2024/4/3 9:14
 * @Version 1.0
*/
public class ProblemsNo1379 {

    @Test
    public void solution() {
        TreeNode head = new TreeNode(1);
        System.out.println("res = " + getTargetCopy(head, head, head));
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(target == original || original == null) {
            return cloned;
        }
        TreeNode treeNode = getTargetCopy(original.left, cloned.left, target);
        if(treeNode != null) {
            return treeNode;
        }
        return  getTargetCopy(original.right, cloned.right, target);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}

