package com.itheima.week9.avl_tree;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-31 11:13
 **/
public class AvlTree {
    private AvlNode root = null;
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("该树的前序遍历结果为:");
        preOrder(root, sb);
        sb.append("该树的中序遍历结果为:");
        inOrder(root, sb);
        
        sb.append("该树的后序遍历结构为:");
        postOrder(root, sb);
        return sb.toString();
    }
    
    private void inOrder(AvlNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        inOrder(node.left, sb);
        sb.append(node.key).append("->");
        inOrder(node.right, sb);
    }
    
    private void preOrder(AvlNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.key).append("->");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }
    
    private void postOrder(AvlNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.key).append("->");
    }
    
    public void insert(int key) {
        root = insert(root, key);
    }
    
    private AvlNode insert(AvlNode node, int key) {
        //terminal
        if (node == null) {
            return new AvlNode(key);
        }
        if (node.key < key) {
            node.right = insert(node.right, key);
            if (Math.abs(getHeight(node.right) - getHeight(node.left)) > 1) {
                //    绝对值大于1,就转 RR还是RL
                if (key > node.right.key) {
                    //RR
                    node = RRrotate(node);
                } else {
                    //RL
                    node = RLrotate(node);
                }
            }
        } else if (node.key > key) {
            node.left = insert(node.left, key);
            if (Math.abs(getHeight(node.right) - getHeight(node.left)) > 1) {
                //    绝对值大于1,就转 LR还是LL
                if (key > node.left.key) {
                    //LR
                    node = LRrotate(node);
                } else {
                    //LL
                    node = LLrotate(node);
                }
            }
        } else {
        }
        node.height = Math.max(getHeight(node.right), getHeight(node.left)) + 1;
        return node;
        //
    }
    
    public AvlNode RRrotate(AvlNode unbalance) {
        AvlNode newNode = unbalance.right;
        unbalance.right = newNode.left;
        newNode.left = unbalance;
        //重新设置高度
        unbalance.height = Math.max(getHeight(unbalance.left), getHeight(unbalance.right)) + 1;
        newNode.height = Math.max(getHeight(newNode.left), getHeight(newNode.right)) + 1;
        return newNode;
    }
    
    public AvlNode LLrotate(AvlNode unbalance) {
        AvlNode newNode = unbalance.left;
        unbalance.left = newNode.right;
        newNode.right = unbalance;
        //重新设置高度
        unbalance.height = Math.max(getHeight(unbalance.left), getHeight(unbalance.right)) + 1;
        newNode.height = Math.max(getHeight(newNode.left), getHeight(newNode.right)) + 1;
        return newNode;
    }
    
    public AvlNode LRrotate(AvlNode unbalance) {
        unbalance.left = RRrotate(unbalance.left);
        return LLrotate(unbalance);
    }
    
    public AvlNode RLrotate(AvlNode unbalance) {
        unbalance.right = LLrotate(unbalance.right);
        return RRrotate(unbalance);
    }
    
    public int getHeight(AvlNode node) {
        return node == null ? 0 : node.height;
    }
    
    public static class AvlNode {
        int key;
        AvlNode left;
        AvlNode right;
        int height = 1;
        
        /**
         * 我们取第一种高度定义:从根节点到最深节点的最长路径的节点数
         * 故：空树高度记为0，叶子节点高度记为1
         */
        public AvlNode(int key) {
            this.key = key;
        }
    }
}
