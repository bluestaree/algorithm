package com.itheima.week9.avl_tree_1;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-10-07 16:53
 **/
public class AvlTree {
    TreeNode root;
    
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
    
    private void inOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        inOrder(node.left, sb);
        sb.append(node.val).append("->");
        inOrder(node.right, sb);
    }
    
    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val).append("->");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }
    
    private void postOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.val).append("->");
    }
    
    /**
     * 获取节点的高度
     * 这里高度的定义是：从根节点到最深节点的最长路径的节点数。
     *
     * @param node
     * @return
     */
    public int getHeight(TreeNode node) {
        // 空树的高度为0
        
        return node == null ? 0 : node.height;
    }
    
    /**
     * RR旋转:对失衡节点进行左旋
     * 20               30
     * / \             / \
     * 10 30          20 40
     * / \ --RR旋转- / \ \
     * 25 40        10 25 50
     * \
     * 50
     *
     * @param unbalance 失衡节点
     * @return 调整后的根节点
     */
    public TreeNode RRrotate(TreeNode unbalance) {
        
        TreeNode root = unbalance.right;
        unbalance.right = root.left;
        root.left = unbalance;
        /**
         * 重新设置失衡点20和新节点30的高度 其他节点的高度不变
         * 节点高度如何确定？
         * 节点的高度= Math.max(左子树的高度,右子树的高度) +1
         */
        unbalance.height = Math.max(getHeight(unbalance.left), getHeight(unbalance.right)) + 1;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }
    
    /**
     * LL旋转：对失衡节点进行右旋
     * 30               20
     * / \             / \
     * 20 40          10 30
     * / \ --LL旋转-  / / \
     * 10 25        5 25 40
     * /
     * 5
     *
     * @param unbalance 失衡节点
     * @return 调整后的根节点
     */
    public TreeNode LLrotate(TreeNode unbalance) {
        TreeNode root = unbalance.left;
        unbalance.left = root.right;
        root.right = unbalance;
        
        unbalance.height = Math.max(getHeight(unbalance.left), getHeight(unbalance.right)) + 1;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }
    
    /**
     * LR旋转：先对失衡节点的左子树按RR情况处理，再对失衡节点按LL处理
     *
     * @param unbalance
     * @return
     */
    public TreeNode LRrotate(TreeNode unbalance) {
        //
        RRrotate(unbalance.left);
        return LLrotate(unbalance);
    }
    
    /**
     * RL旋转：先对失衡节点的右子树按LL情况处理，再对失衡节点按RR情况处理
     *
     * @param unbalance
     * @return
     */
    public TreeNode RLrotate(TreeNode unbalance) {
        LLrotate(unbalance.right);
        return RRrotate(unbalance);
    }
    
    /**
     * 插入操作涉及到从根节点开始依次进行比较，直到插入。插入完成后要从原路回溯查找失衡节
     * 点，并且进行旋转调整，故相对较好的实现方式是基于递归来完成
     *
     * @param key
     */
    public void insert(int key) {
        if (root.val >= key) {
            insert(root.left, key);
        } else {
            insert(root.right, key);
        }
    }
    
    /**
     * 针对一棵二叉搜索树,通过递归的方式去插入
     * 同时在回溯的过程中找到失衡节点,判断属于RR,LL,LR,RL中的哪种情况，进行旋转调整，
     * 最后插入路线上的每个节点需要重新调整高度
     */
    private TreeNode insert(TreeNode tree, int key) {
        //终止条件
        if (tree == null) {
            return new TreeNode(key);
        }
        //当前层处理
        if (tree.val > key) {
            tree.left = insert(tree.left, key);
            //平衡处理
            int rh = getHeight(tree.right);
            int lh = getHeight(tree.left);
            if (Math.abs(rh - lh) > 1) {
                //说明不平衡了,需要进行平衡调整
                //LR  LL 
                if (key > tree.left.val) {
                    //LR
                    tree = LRrotate(tree);
                } else {
                    //Ll
                    tree = LLrotate(tree);
                }
            }
        } else if (tree.val < key) {
            tree.right = insert(tree.right, key);
            
            //平衡处理
            int rh = getHeight(tree.right);
            int lh = getHeight(tree.left);
            if (Math.abs(rh - lh) > 1) {
                //说明不平衡了,需要进行平衡调整
                if (key > tree.right.val) {
                    //RR
                    tree = RRrotate(tree);
                } else {
                    //RL
                    tree = RLrotate(tree);
                }
            }
        } else {
            //不处理
        }
        tree.height = Math.max(getHeight(tree.left), getHeight(tree.right)) + 1;
        return tree;
    }
    
}
