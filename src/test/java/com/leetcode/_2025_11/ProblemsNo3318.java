package com.leetcode._2025_11;

import org.junit.Test;

import java.util.*;


/**
 * 3318. 计算子数组的 x-sum I
 *
 * @author DHW
 * @date 2025/11/4 8: 43
 * @Version 1.0
*/
public class ProblemsNo3318 {

    @Test
    public void solution() {
        int[] nums =  new int[]{757156198,618061041,177742251,693552197,693552197,693552197,618061041,693552197,177742251,286583866,177742251,693552197};
        int k = 8;
        int x = 4;
        System.out.println("res = " + findXSum(nums, k, x));
    }

    public long[] findXSum1(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(i >= k - 1) {
                if(i >= k && nums[i - k] == nums[i]) {
                    ans[i - k + 1] = ans[i - k];
                    map.merge(nums[i - k + 1], -1, Integer::sum);
                    continue;
                }
                extracted1(x, map, ans, i - k + 1);
                map.merge(nums[i - k + 1], -1, Integer::sum);
            }
        }
        return ans;
    }

    private static void extracted1(int x, HashMap<Integer, Integer> map, long[] ans, int i) {
        List<Map.Entry<Integer, Integer>> toList = new ArrayList<>(map.entrySet());
        toList.sort(
                Map.Entry.<Integer, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.<Integer, Integer>comparingByKey().reversed()));
        int num = 0;
        for (int j = 0; j < x && j < toList.size(); j++) {
            num += toList.get(j).getKey() * toList.get(j).getValue();
        }
        ans[i] = num;
    }


    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        extracted(x, map, ans, 0);
        for (int i = k; i < n; i++) {
            if(nums[i - k] == nums[i]) {
                ans[i - k + 1] = ans[i - k];
                continue;
            }
            Integer c = map.get(nums[i - k]);
            if(c == 1) {
                map.remove(nums[i - k]);
            } else {
                map.put(nums[i - k], map.get(nums[i - k]) - 1);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            extracted(x, map, ans, i - k + 1);
        }
        return ans;
    }

    private static void extracted(int x, HashMap<Integer, Integer> map, int[] ans, int i) {
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        ArrayList<int[]> list = new ArrayList<>();
        int num = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
            num += entry.getKey() * entry.getValue();
        }
        if(map.size() < x) {
            ans[i] = num;
            return;
        }
        Collections.sort(list, (a, b) -> a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]);
        num = 0;
        for (int j = 0; j < x; j++) {
            int[] b = list.get(j);
            num += b[0] * b[1];
        }
        ans[i] = num;
    }


}

