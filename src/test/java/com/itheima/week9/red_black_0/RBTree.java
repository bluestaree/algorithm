package com.itheima.week9.red_black_0;

import com.itheima.week9.red_black.printer.BinaryTreeInfo;

/**
 * @program: algo_pro
 * @description: 红黑树
 * @author: zhanghz001
 * @create: 2021-10-08 09:59
 **/
public class RBTree implements BinaryTreeInfo {
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    
    //根节点
    Node root;
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
    private boolean isBlack(Node node) {
        return colorOf(node) == BLACK;
    }
    
    /**
     * 判断节点是否是红色
     *
     * @param node
     * @return
     */
    private boolean isRed(Node node) {
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
    
    public void add(int key) {
        //判断root是否为空
        if (root == null) {
            root = new Node(key, null);
            afterAdd(root);
            return;
        }
        //找到新节点应插入到哪个位置
        Node parent = null;
        Node curr = root;
        while (curr != null) {
            parent = curr;
            if (key > parent.key) {
                curr = curr.right;
            } else if (key < curr.key) {
                curr = curr.left;
            }
        }
        //判断新节点是插入到parent的左子树还是右子树上
        Node newNode = new Node(key, parent);
        if (key > parent.key) {
            parent.right = newNode;
        } else if (key < parent.key) {
            parent.left = newNode;
        }
        afterAdd(newNode);
    }
    
    /**
     * 添加完成后的红黑树进行调整
     *
     * @param node 新添加的节点
     */
    public void afterAdd(Node node) {
        Node parent = node.parent;
        //如果新添加的节点是根节点 或者向上调整到了根节点
        if (parent == null) {
            black(node);
            return;
        }
        
        //如果父节点是黑色,就不需要调整
        if (isBlack(parent)) {
            return;
        }
        //如果父节点是红色则又分两种逻辑（叔父节点不是红色/叔父节点是红色）
        Node uncle = parent.sibling();
        Node grand = red(parent.parent);
        /**
         * 叔父节点是红色：
         * 染色：父节点和叔父节点染黑色,祖父染红色
         * 向上合并：将祖父节点当作新添加的节点继续整个这套流程
         */
        if (isRed(uncle)) {
            black(parent);
            black(uncle);
            //不知道为什么要注释
            // red(grand);
            afterAdd(grand);
            return;
        }
        /**
         * 叔父节点不是红色：判断当前是属于：RR,LL,LR,RL中的哪种情况
         * RR/LL：
         1、染色：父节点染成黑色，
         祖父节点染成红色
         2、祖父节点进行旋转操作
         分别为 RR旋转和LL旋转
         * LR/RL:
         1、进行旋转操作
         LR:父节点左旋，祖父右旋
         RL:父节点右旋，祖父左旋
         2、染色：自己染成黑色，
         祖父节点染成红色
         */
        if (parent.isLeftChild()) {
            //L
            if (node.isLeftChild()) {
                //LL
                black(parent);
                // red(grand);
                LLrotate(grand);
            } else {
                //LR
                black(node);
                // red(grand);
                LRrotate(grand);
            }
        } else {
            //R
            if (node.isLeftChild()) { //RL
                black(node);
                //red(grand);
                RLrotate(grand);
            } else { // RR
                black(parent);
                //red(grand);
                RRrotate(grand);
            }
        }
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
    
    private Node RLrotate(Node grand) {
        LLrotate(grand.right);
        return RRrotate(grand);
    }
    
    private Node LRrotate(Node grand) {
        RRrotate(grand.left);
        return LLrotate(grand);
    }
    
    /**
     * 删除节点
     *
     * @param key
     */
    public void remove(int key) {
        remove(node(key));
    }
    
    private Node node(int key) {
        //从根节点开始查找要删除的节点
        Node node = root;
        while (node != null) {
            if (key > node.key) {
                node = node.right;
            } else if (key < node.key) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }
    
    /**
     * 删除节点
     *
     * @param node 被删除节点
     */
    private void remove(Node node) {
        if (node == null) {
            return;
        }
        //度为2的节点
        if (node.hasTwoChildren()) {
            //后继节点替换当前节点,真正删除的是后继节点
            Node p = node.right;
            while (p.left != null) {
                p = p.left;
            }
            //后继节点的值覆盖度为2的节点的值
            node.key = p.key;
            //真正被删除的是其后继节点
            node = p;
        }
        
        //真正被删除的节点是度为0和度为1的节点
        // 找到替代节点
        Node replacement = node.left != null ? node.left : node.right;
        if (node.parent == null) {
            //node是根节点
            root = replacement;
        } else if (node.isLeftChild()) {
            node.parent.left = replacement;
        } else {
            node.parent.right = replacement;
        }
        
        //删除后的调整---后文实现
        afterRemove(node, replacement);
        
    }
    
    /**
     * 删除后的调整
     *
     * @param beRemoved
     * @param replacement
     */
    
    private void afterRemove(Node beRemoved, Node replacement) {
        //被删除节点是红色，无需调整
        if (isRed(beRemoved)) {
            return;
        }
        
        //被删除的节点是黑色
        //被删除节点是黑色且有红色替代子节点,将其染黑色即可
        if (isRed(replacement)) {
            black(replacement);
            return;
        }
        
        //被删除节点是黑色叶子 且是根节点 无需操作了
        Node parent = beRemoved.parent;
        if (parent == null) {
            return;
        }
        
        //被删除节点是黑色叶子，两种情况：通过兄弟节点是黑色还是红色来判断，且被删除节点在
        // 左在右逻辑不一样
        boolean left = parent.left == null || beRemoved.isLeftChild();
        Node sibling = left ? parent.right : parent.left;
        if (left) {
            //被删除的节点在左边，兄弟节点在右边
            //兄弟节点是红色
            if (isRed(sibling)) {
                black(sibling);
                red(parent);
                LLrotate(parent);
                sibling = parent.right;
            }
            
            //兄弟是黑色
            //黑兄弟无红色子节点
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                boolean parentBlack = isBlack(parent);
                red(sibling);
                black(parent);
                if (parentBlack) {
                    afterRemove(parent, null);
                }
            } else { //黑兄弟至少有一个红色子节点 LL,LR
                Node newParent;
                if (isRed(sibling.left)) {
                    newParent = RRrotate(parent);
                    color(newParent, colorOf(parent));
                } else {
                    newParent = RLrotate(parent);
                    color(newParent, colorOf(parent));
                }
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
    
    /**
     * NODE节点
     */
    public static class Node {
        //false 红色, true 黑色
        boolean color = RED;
        int key;
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
            }
            if (isRightChild()) {
                return parent.left;
            }
            return null;
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
