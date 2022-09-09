package com.itheima.week10.binary;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-01-13 21:04
 **/
public class BinaryTest {
    
    @Test
    public void test191位1的个数() {
        System.out.println(hammingWeight(15));
    }
    
    public int hammingWeight1(int n) {
        
        //
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    
    public int hammingWeight(int n) {
        
        return Integer.bitCount(n);
    }
    
    public int hammingWeight2(int n) {
        
        //
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
    
    @Test
    public void test231_2的幂() {
        System.out.println(isPowerOfTwo(4));
    }
    
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
    
    @Test
    public void test190颠倒二进制位() {
        System.out.println(reverseBits(4));
    }
    
    public int reverseBits1(int n) {
        return Integer.reverse(n);
    }
    
    //按位翻转
    public int reverseBits2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                res = res | (1 << (31 - i));
            }
            n >>= 1;
        }
        return res;
    }
    
    //按位翻转
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (n & (1 << i)) != 0 ? (1 << (31 - i)) : 0;
        }
        return res;
    }
    
    @Test
    public void test52_N皇后II() {
        System.out.println(totalNQueens(4));
    }
    
    public int totalNQueens(int n) {
        dfs(n, 0, 0, 0, 0);
        return count;
    }
    
    int count = 0;
    
    private void dfs1(int n, int row, int col, int pie, int na) {
        //结束
        if (row == n) {
            count++;
            return;
        }
        //当前层循环
        int bits = (~(col | pie | na)) & ((1 << n) - 1);
        while (bits > 0) {
            
            //bits中为1 的位才能放            
            int mask = bits & (-bits);
            dfs1(n, row + 1, col | mask,
                    (pie | mask) >> 1,
                    (na | mask) << 1);
            bits = bits & (bits - 1);
        }
    }
    
    private void dfs(int n, int row, int col, int pie, int na) {
        //终止条件
        if (row == n) {
            count++;
            return;
        }
        
        //需要做好循环
        for (int i = n - 1; i >= 0; i--) {
            int iBit = 1 << i;
            if ((col & iBit) == 1) {
                //说明i位已经使用
                continue;
            }
            if ((pie & iBit) == 1) {
                //说明i位已经使用
                continue;
            }
            if ((na & iBit) == 1) {
                //说明i位已经使用
                continue;
            }
            //可以进入下一层
            dfs(n, row + 1, col | iBit, (pie | iBit) << 1, (na | iBit) >> 1);
            
        }
    }
    
    @Test
    public void test338比特位计数() {
        System.out.println(Arrays.toString(countBits(5)));
    }
    
    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = 0;
            //判断i的1的个数
            int data = i;
            while (data > 0) {
                data = data & (data - 1);
                count++;
            }
            res[i] = count;
        }
        return res;
    }
    
    /**
     * 这个好妙呀,就是通过一半的1的数量,在判断最后一位就可以判断出来了
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
