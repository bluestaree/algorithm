package com.itheima.week9.red_black;

import com.itheima.week9.red_black.printer.BinaryTreeInfo;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-01-10 15:37
 **/
public class RBTree implements BinaryTreeInfo {
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    Node root = null;
    
    //
    public void add(int key) {
        //根节点添加
        if (root == null) {
            root = new Node(key, null);
            root.color = BLACK;
            return;
        }
        //添加到对应的节点
        Node node = root;
        Node parent = null;
        while (node != null) {
            parent = node;
            if (node.key > key) {
                node = node.left;
                
            } else if (node.key < key) {
                node = node.right;
                
            } else {
                return;
            }
        }
        //判断新节点是插入到parent的左子树还是右子树上
        Node newNode = new Node(key, parent);
        if (parent.key > key) {
            parent.left = newNode;
        }
        if (parent.key < key) {
            parent.right = newNode;
        }
        //
        afterAdd(newNode);
        
    }
    
    private void afterAdd(Node node) {
        //如果是根节点
        if (root == node) {
            black(node);
            return;
        }
        
        Node parent = node.parent;
        //如果父节点是黑色,就返回
        if (isBlack(parent)) {
            return;
        }
        Node uncle = parent.sibling();
        Node grand = red(parent.parent);
        //如果父节点是红色,uncle是红色
        if (isRed(uncle)) {
            black(parent);
            black(uncle);
            //小心没有祖父
            // red(grand);
            //如果父节点是红色则又分两种逻辑（叔父节点不是红色/叔父节点是红色）
            afterAdd(grand);
            return;
        }
        //如果父节点是红色,uncle是黑色
        if (parent.isLeftChild()) {
            //L
            //LL
            if (node.isLeftChild()) {
                black(parent);
                // red(grand);
                LLrotate(grand);
            }
            //LR
            if (node.isRightChild()) {
                black(node);
                // red(grand);
                LRrotate(grand);
            }
        } else if (parent.isRightChild()) {
            //R 
            //RR
            if (node.isRightChild()) {
                black(parent);
                // red(grand);
                RRrotate(grand);
                
            } else if (node.isLeftChild()) {
                //RL
                black(node);
                // red(grand);
                RLrotate(grand);
            }
        }
        // 
    }
    
    /**
     * 删除节点
     *
     * @param key
     */
    
    public void remove(int key) {
        remove(node(key));
    }
    
    /**
     * 删除节点
     *
     * @param node 被删除节点
     */
    private void remove(Node node) {
        //节点不存在
        if (node == null) {
            return;
        }
        //节点是度为2的节点,找到前驱节点
        if (node.hasTwoChildren()) {
            Node p = node.left;
            while (p.right != null) {
                p = p.right;
            }
            node.key = p.key;
            node = p;
        }
        
        Node replacement = node.left == null ? node.right : node.left;
        
        //根节点统一处理
        
        Node grand = node.parent;
        if (grand == null) {
            //node是根节点
            root = replacement;
        } else if (node.isLeftChild()) {
            //左边
            grand.left = replacement;
            
        } else {
            //右边
            grand.right = replacement;
        }
        if (replacement != null) {
            //度为1的节点          
            //node必定是黑色节点,replacement红色
            replacement.parent = grand;
        }
        //删除后的调整---后文实现
        afterRemove(node, replacement);
        //替换后删除node的所有指向
        node.parent = null;
        node.right = null;
        node.left = null;
    }
    
    private void afterRemove(Node beRemoved, Node replacement) {
        if (replacement != null) {
            //度为1
            black(replacement);
            return;
        }
        //度为0
        
        //红色叶子节点
        if (isRed(beRemoved)) {
            return;
        }
        //黑色叶子,且是根节点
        Node parent = beRemoved.parent;
        if (parent == null) {
            return;
        }
        //   被删除节点是黑色叶子，两种情况：通过兄弟节点是黑色还是红色来判断，且被删除节点在
        // 左在右逻辑不一样
        boolean left = beRemoved.isLeftChild() || parent.left == null;
        Node sibling = left ? parent.right : parent.left;
        if (left) {
            //左边
            //情况2转换
            if (isRed(sibling)) {
                red(parent);
                black(sibling);
                RRrotate(parent);
                sibling = parent.right;
            }
            
            //兄弟是黑色
            //兄弟是不是有红色子节点
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                //没有红色子节点
                if (isRed(parent)) {
                    black(parent);
                    red(sibling);
                } else {
                    //父节点是黑色
                    red(sibling);
                    afterRemove(parent, null);
                }
            } else {
                //有红色子节点
                Node newParent;
                if (isRed(sibling.right)) {
                    //通过RR旋转 ,右边
                    newParent = RRrotate(parent);
                } else {
                    //RL,sibling只有左边子节点
                    newParent = RLrotate(parent);
                }
                color(newParent, colorOf(parent));
                black(newParent.left);
                black(newParent.right);
            }
            
        } else {
            //右边
            //情况2转换            
            if (isRed(sibling)) {
                red(parent);
                black(sibling);
                LLrotate(parent);
                sibling = parent.left;
            }
            
            //兄弟是黑色
            //兄弟是不是有红色子节点
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                //没有红色子节点
                if (isRed(parent)) {
                    black(parent);
                    red(sibling);
                } else {
                    //父节点是黑色
                    red(sibling);
                    afterRemove(parent, null);
                }
            } else {
                //有红色子节点
                Node newParent;
                if (isRed(sibling.left)) {
                    //通过RR旋转 ,右边
                    newParent = LLrotate(parent);
                } else {
                    //RL,sibling只有左边子节点
                    newParent = LRrotate(parent);
                }
                color(newParent, colorOf(parent));
                black(newParent.left);
                black(newParent.right);
            }
        }
    }
    
    private Node node(int key) {
        Node node = root;
        //树为空
        if (node == null) {
            return null;
        }
        //
        while (node != null) {
            if (key > node.key) {
                node = node.right;
            } else if (key < node.key) {
                node = node.left;
            } else {
                return node;
            }
        }
        //找不到
        return null;
    }
    
    private Node RLrotate(Node grand) {
        LLrotate(grand.right);
        return RRrotate(grand);
    }
    
    private Node LRrotate(Node grand) {
        RRrotate(grand.left);
        return LLrotate(grand);
    }
    
    //左旋
    private Node RRrotate(Node left) {
        Node newParent = left.right;
        left.right = newParent.left;
        if (newParent.left != null) {
            newParent.left.parent = left;
        }
        newParent.left = left;
        newParent.parent = left.parent;
        if (left.isLeftChild()) {
            left.parent.left = newParent;
        } else if (left.isRightChild()) {
            left.parent.right = newParent;
        } else {
            //root是根节点
            root = newParent;
        }
        
        left.parent = newParent;
        
        return newParent;
    }
    
    private Node LLrotate(Node right) {
        //
        Node newParent = right.left;
        Node son = newParent.right;
        Node grand = right.parent;
        //grand和newParent指向
        if (right.isRightChild()) {
            grand.right = newParent;
        } else if (right.isLeftChild()) {
            grand.left = newParent;
        } else {
            root = newParent;
        }
        newParent.parent = grand;
        //newParent right
        newParent.right = right;
        right.parent = newParent;
        
        //right son
        right.left = son;
        if (son != null) {
            son.parent = right;
        }
        
        return newParent;
    }
    
    ///-------------------------辅助函数------------------------
    
    /**
     * 给节点node染色并返回该节点
     *
     * @param node
     * @param color
     * @return
     */
    private Node color(Node node, boolean color) {
        if (node == null) {
            return node;
        }
        node.color = color;
        return node;
    }
    
    /**
     * 将节点染成红色
     *
     * @param node
     * @return
     */
    private Node red(Node node) {
        return color(node, RED);
    }
    
    /**
     * 将节点染成黑色
     *
     * @param node
     * @return
     */
    private Node black(Node node) {
        return color(node, BLACK);
    }
    
    /**
     * 返回节点的颜色
     *
     * @param node
     * @return
     */
    public boolean colorOf(Node node) {
        return node == null ? BLACK : node.color;
    }
    
    /**
     * 判断节点是否是黑色
     *
     * @param node
     * @return
     */
    public boolean isBlack(Node node) {
        return colorOf(node) == BLACK;
    }
    
    /**
     * 判断节点是否是红色
     *
     * @param node
     * @return
     */
    public boolean isRed(Node node) {
        return colorOf(node) == RED;
    }
    
    ///------------BinaryTreeInfo接口的几个实现
    @Override
    public Object root() {
        return root;
    }
    
    @Override
    public Object left(Object node) {
        return ((Node) node).left;
    }
    
    @Override
    public Object right(Object node) {
        return ((Node) node).right;
    }
    
    @Override
    public Object string(Object node) {
        return node;
    }
    
    //
    static class Node {
        int key;
        boolean color = RED;
        Node left;
        Node right;
        Node parent;
        
        public Node(int key, Node parent) {
            this.key = key;
            this.parent = parent;
        }
        
        /**
         * 判断当前节点是否是最后一层的叶子(并非指红黑树中的叶子节点)
         *
         * @return
         */
        public boolean isLeaf() {
            return left == null && right == null;
        }
        
        /**
         * 判断是否有两个子节点
         *
         * @return
         */
        public boolean hasTwoChildren() {
            return left != null && right != null;
        }
        
        /**
         * 判断当前节点是否是其父节点的左子节点
         *
         * @return
         */
        public boolean isLeftChild() {
            return parent != null && parent.left == this;
        }
        
        /**
         * 判断当前节点是否是其父节点的右子节点
         *
         * @return
         */
        public boolean isRightChild() {
            return parent != null && parent.right == this;
        }
        
        /**
         * 获取当前节点的兄弟节点
         *
         * @return
         */
        public Node sibling() {
            if (isLeftChild()) {
                return parent.right;
            } else if (isRightChild()) {
                return parent.left;
            } else {
                return null;
            }
        }
        
        @Override
        public String toString() {
            String str = "";
            if (color == RED) {
                str = "R_";
            }
            return str + key;
        }
    }
}
