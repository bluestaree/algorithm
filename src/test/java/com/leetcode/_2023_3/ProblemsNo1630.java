package com.leetcode._2023_3;

import org.junit.Test;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 1630. 等差子数组
 *
 * @author DHW
 * @date 2023/3/23 10:33
 * @Version 1.0
*/
public class ProblemsNo1630 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,6,5,9,3,7};
        int[] l = new int[]{0,0,2};
        int[] r = new int[]{2,3,5};
        System.out.println("res = " + checkArithmeticSubarrays(nums, l, r));
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        ArrayList<Boolean> res = new ArrayList<>();
        int m = l.length;
        int left;
        int right;
        int len;
        int val;
        boolean flag;
        for (int i = 0; i < m; i++) {
            flag = true;
            left = l[i];
            right = r[i];
            len = right - left + 1;
            int[] target = new int[len];
            System.arraycopy(nums, left, target, 0, len);
            Arrays.sort(target);
            val = target[1] - target[0];
            for (int j = 2; j < len; j++) {
                if(target[j] - target[j-1] != val) {
                    flag = false;
                    break;
                }
            }
            res.add(flag);
        }

        return res;
    }
}
