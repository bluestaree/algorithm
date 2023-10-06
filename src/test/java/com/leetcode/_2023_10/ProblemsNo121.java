package com.leetcode._2023_10;

import com.sun.xml.internal.ws.assembler.jaxws.ValidationTubeFactory;
import org.junit.Test;

import java.io.FileReader;
import java.util.Arrays;


/**
 * 121. 买卖股票的最佳时机
 *
 * @author DHW
 * @date 2023/10/1 12:19
 * @Version 1.0
*/
public class ProblemsNo121 {

    @Test
    public void solution() {
        int[] prices = new int[]{1,2,3,1};
        System.out.println("res = " + maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        int length = prices.length;
        Integer[] indexs = new Integer[length];
        for (int i = 0; i < length; i++) {
            indexs[i] = i;
        }
        Arrays.sort(indexs, (a,b) -> prices[a] - prices[b]);

        for (int i = 0; i < indexs.length; i++) {
            for (int j = indexs.length - 1; j > i; j--) {
                if(indexs[i] < indexs[j]) {
                   res = Math.max(res, prices[indexs[j]] - prices[indexs[i]]);
                   break;
                }
            }
        }
        return res;
    }

    public int maxProfit1(int[] prices) {
        int ans = 0, mi = prices[0];
        for (int v : prices) {
            ans = Math.max(ans, v - mi);
            mi = Math.min(mi, v);
        }
        return ans;
    }
}

