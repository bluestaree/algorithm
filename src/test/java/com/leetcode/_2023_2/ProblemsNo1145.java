package com.leetcode._2023_2;

import org.junit.Test;

import java.util.HashMap;


/**
 * 1145. 二叉树着色游戏
 *
 * @author DHW
 * @date 2023/2/3 11:11
 * @Version 1.0
*/
public class ProblemsNo1145 {

    @Test
    public void solution() {
    }

    /**
     * 取胜的关键是取得一半以上的节点数量，
     *
     * 节点 x 将二叉树分成三个区域：节点 x 的左子树、节点 x 的右子树和其余节点，三个区域的节点总数是 n−1，每个区域可能为空。
     *
     * 由于一号玩家已经选择节点 x 着色，因此二号玩家只能在三个区域中选择一个节点着色，且之后只能在相同的区域选择节点着色。
     * 二号玩家的目标是使自己着色的节点数大于一号玩家着色的节点数，因此二号玩家应使自己着色的节点数最大化，二号玩家的策略如下：
     *
     *      二号玩家应选择节点数最多的区域中的一个节点着色。
     *      且对于选定的区域，二号玩家应使自己在该区域中着色的节点数最大化，着色的最大节点数应等于该区域的节点数，
     *      因此二号玩家应避免一号玩家在该区域中选择节点着色。
     *      为了做到这一点，二号玩家应选择该区域中与节点 x 相邻的节点着色，此时一号玩家无法在该区选择节点着色，
     *      二号玩家可以将该区域的所有节点着色。
     *
     * 因此，通过分析，我们直到以下三种选择能够最大程度地阻断对方可染色的范围，从而使自己占据最多的可染色范围：
     *      选择x的左子节点；（左子树节点全归自己）
     *      选择x的右子节点；（右子树节点全归自己）
     *      选择x的父节点。 （父节点所在连通分量全归自己）
     *
     * 因此只要三个区域有一个区域的节点数 > n/2 ，那么二号玩家选择此区域代表节点（x的左、右、父节点）作为y，即可取胜
     *
     * 因此我们通过 dfs 得到 整棵树全部节点数 m，找到 节点 x，计算 x左右子树节点数 l、r，
     * 只要 l > 2/n, r > 2/n, m-l-r-1 > n/2 三个条件成立一个，二号玩家即可取胜。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/binary-tree-coloring-game/solution/er-cha-shu-zhao-se-you-xi-by-leetcode-so-ruys/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @param n
     * @param x
     * @return
     */
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // 找到节点x
        TreeNode nodeX = find(root, x);
        // 区域1：x的左子树的节点数
        int ls = getSize(nodeX.left);
        // 区域2：x的右子树的节点数
        int rs = getSize(nodeX.right);
        // 区域3：剩下部分，x的父节点所在联通分量的节点数
        // 三者有一 大于 n/2 即可。
        return ls > n / 2 || rs > n / 2 || (n - ls - rs - 1) > n / 2;
    }

    /**
     * 在以 root 为根的子树中寻找值等于x的节点
     * @param root
     * @param x
     * @return
     */
    private TreeNode find(TreeNode root, int x) {
        // 节点为空或找到
        if (root == null || root.val == x) {
            return root;
        }
        // 在左子树中寻找
        TreeNode node = find(root.left, x);
        // 若找到则返回，否则在右子树中寻找
        return node != null ? node : find(root.right, x);
    }

    /**
     * 计算以root为根的子树的节点数
     * @param root
     * @return
     */
    private int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }

   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }

}
