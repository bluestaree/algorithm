package com.leetcode._2023_9;

import org.junit.Test;

import javax.lang.model.element.VariableElement;
import java.util.*;


/**
 * 1993. 树上的操作
 *
 * @author DHW
 * @date 2023/9/23 13:43
 * @Version 1.0
*/
public class ProblemsNo1993 {

    @Test
    public void solution() {
        LockingTree obj = new LockingTree(new int[]{-1, 0, 0, 1, 1, 2, 2});
        boolean param_1 = obj.lock(2,2);
        boolean param_2 = obj.unlock(2,3);
        boolean param_3 = obj.unlock(2,2);
        boolean param_4 = obj.lock(4,5);
        boolean param_5 = obj.upgrade(0,1);
        boolean param_6 = obj.lock(0,1);
    }

    class LockingTree {
            private int parent[];
            private List<Integer>[] children;
            private int[] locked;
            private boolean upgradeFlag = false;

            public LockingTree(int[] parent) {
                this.parent = parent;
                int length = parent.length;
                this.locked = new int[length];
                Arrays.fill(locked, -1);
                this.children = new List[length];
                for (int i = 0; i < length; i++) {
                    children[i] = new ArrayList<>();
                }

                for (int i = 1; i < length; i++) {
                    children[parent[i]].add(i);
                }
            }

            public boolean lock(int num, int user) {
                if(locked[num] == -1) {
                    locked[num] = user;
                    return true;
                }
                return false;
            }

            public boolean unlock(int num, int user) {
                if (locked[num] == user) {
                    locked[num] = -1;
                    return true;
                }
                return false;
            }

            public boolean upgrade(int num, int user) {
                this.upgradeFlag = false;
                int a = num;
                while(a != -1) {
                    if(locked[a] != -1) {
                        return false;
                    }
                    a = parent[a];
                }
                dfs(num);
                if(upgradeFlag) {
                    locked[num] = user;
                    return true;
                }
                return false;
            }

            private void dfs(int parentId) {
                List<Integer> child = children[parentId];
                for (Integer i : child) {
                    if(locked[i] != -1) {
                        locked[i] = -1;
                        this.upgradeFlag = true;
                    }
                    dfs(i);
                }
            }
    }

}
