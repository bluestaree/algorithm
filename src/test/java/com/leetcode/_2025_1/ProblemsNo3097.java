package com.leetcode._2025_1;

import org.junit.Test;


/**
 * 3097. 或值至少为 K 的最短子数组 II
 *
 * @author DHW
 * @date 2025/1/17 8: 53
 * @Version 1.0
*/
public class ProblemsNo3097 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,6};
        int k = 2;
        System.out.println("res = " + minimumSubarrayLength(nums,k));
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        if (k==0) return 1; // 太坑了，因为一开始tmp初始化的是0，那其实没添加数字时就满足条件了，所以要额外处理一下
        int n=nums.length; int ans=n+1; // ans<=n，让它等于n+1，如果最后还是n+1说明没找到返回-1
        int tmp=0; // a|0=a，初始化，相当于算sum的0，算prod的1

        for (int i=0, j=0; i<n; i++){ //左i闭右j开
            while (j<n&&tmp<k) tmp|=nums[j++]; //找到窗口右端点使窗口内满足条件
            if (tmp<k) break; //j到头了还不满足条件直接结束
            for (int l=j-1, tmp2=0; l>=i; l--){ //从右往左倒序找第一个满足条件的窗口
                tmp=tmp2; //tmp用来保存从右往左计算的上一个结果，这样tmp2>=k时，tmp刚好<k
                tmp2|=nums[l];
                if (tmp2>=k){ //第一个满足条件的窗口
                    ans=Math.min(ans, j-l); // [i,l]内所有到j的区间都满足
                    i=l; //i移动到l，回合结束时i=l+1也就是第一个[l+1,j)的区间不满足条件，而因为tmp存的是上一个tmp2，也就是[l+1,j)的并结果，继续循环就行了
                    break;
                }
            }
        }
        return (ans==n+1)?-1:ans;
    }
}

