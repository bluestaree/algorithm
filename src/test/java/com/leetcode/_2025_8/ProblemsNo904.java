package com.leetcode._2025_8;

import com.sun.jndi.cosnaming.CNCtx;
import org.junit.Test;


/**
 * 904. 水果成篮
 *
 * @author DHW
 * @date 2025/7/16 8: 52
 * @Version 1.0
*/
public class ProblemsNo904 {

    @Test
    public void solution() {
        int[] fruits =  new int[]{3,3,3,1,2,1,1,2,3,3,4};
        System.out.println("res = " + totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0;
        int ans = 1;
        int a = -1;
        int b = -1;
        for (int i = 1; i < n; i++) {
            if(fruits[i] != fruits[i-1]) {
                if(a == -1){
                    a = fruits[i-1];
                    b = fruits[i];
                    continue;
                }
                if(fruits[i] == a || fruits[i] == b) {
                    continue;
                }
                a = fruits[i-1];
                b = fruits[i];
                ans = Math.max(ans, i - left);
                int k = i - 1;
                while(k >= 1 && fruits[k] == fruits[k-1]) {
                    k--;
                }
                left = k;
            }
        }
        ans = Math.max(ans, n - left);
        return ans;
    }

}

