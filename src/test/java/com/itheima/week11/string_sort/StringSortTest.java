package com.itheima.week11.string_sort;

import org.junit.Test;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-01-23 21:05
 **/
public class StringSortTest {
    @Test
    public void test771宝石与石头() {
        numJewelsInStones("", "");
    }
    
    public int numJewelsInStones1(String jewels, String stones) {
        int[] hash = new int[128];//能包含大小写
        char[] sarr = stones.toCharArray();
        for (char c : sarr) {
            hash[c]++;
        }
        char[] jarr = jewels.toCharArray();
        int count = 0;
        for (char c : jarr) {
            if (hash[c] > 0) {
                count += hash[c];
            }
        }
        return count;
    }
    
    public int numJewelsInStones(String jewels, String stones) {
        int[] hash = new int[64];//能包含大小写字母的数组不超过64个
        char[] js = jewels.toCharArray();
        for (char cr : js) {
            hash[cr - 'A']++;
        }
        int count = 0;
        char[] st = stones.toCharArray();
        for (char c : st) {
            if (hash[c - 'A'] > 0) {
                count++;
            }
        }
        return count;
    }
    
    @Test
    public void test709转换成小写字母() {
        System.out.println(toLowerCase(""));
        System.out.println(toLowerCase("LOVEly"));
    }
    
    public String toLowerCase(String str) {
        //初始值判断
        if (str == null) {
            return str;
        }
        int len = str.length();
        if (len == 0) {
            return str;
        }
        //变成新字符串
        int cha = 'a' - 'A';
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') {
                array[i] += cha;
            }
        }
        return new String(array);
    }
    
    @Test
    public void test58最后一个单词的长度() {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   Hello   World   "));
        System.out.println(lengthOfLastWord("       World   "));
    }
    
    public int lengthOfLastWord1(String s) {
        //初始值判断
        if (s == null) {
            return 0;
        }
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        //其他情况
        int j = len - 1;
        char[] array = s.toCharArray();
        while (j >= 0 && array[j] == ' ') {
            j--;
        }
        if (j == -1) {
            return 0;
        }
        int end = j;
        while (j >= 0 && array[j] != ' ') {
            j--;
        }
        return end - j;
    }
    
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }
    
    @Test
    public void test387字符串中的第一个唯一字符() {
        System.out.println(firstUniqChar("  Hello   World  "));
    }
    
    public int firstUniqChar(String s) {
        //初始化
        if (s == null) {
            return -1;
        }
        char[] arr = s.toCharArray();
        int len = arr.length;
        if (len == 0) {
            return -1;
        }
        //循环记录出现次数
        int[] nums = new int[128];
        for (char c : arr) {
            nums[c]++;
        }
        //循环寻找第一个位置
        for (int i = 0; i < arr.length; i++) {
            if (nums[arr[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
    
    @Test
    public void test14最长公共前缀() {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight", "ffff"}));
    }
    
    public String longestCommonPrefix(String[] strs) {
        //初始值判断
        if (strs == null) {
            
            return "";
        }
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        //分治
        return longestCommonPrefix(strs, 0, len - 1);
    }
    
    int min0 = Integer.MAX_VALUE;
    
    private String longestCommonPrefix(String[] strs, int s, int e) {
        //terminal
        if (s == e) {
            return strs[s];
        }
        //下探一层
        int mid = s + ((e - s) >>> 1);
        String leftLcp = longestCommonPrefix(strs, s, mid);
        String rightLcp = longestCommonPrefix(strs, mid + 1, e);
        //当前层处理
        return commonPrefix(leftLcp, rightLcp);
    }
    
    private String commonPrefix(String leftLcp, String rightLcp) {
        
        StringBuilder sb = new StringBuilder();
        int min = Math.min(leftLcp.length(), rightLcp.length());
        min = Math.min(min, min0);
        for (int i = 0; i < min; i++) {
            if (leftLcp.charAt(i) == rightLcp.charAt(i)) {
                sb.append(leftLcp.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }
    
    @Test
    public void test151翻转字符串里的单词() {
        System.out.println(reverseWords("the sky is blue"));
    }
    
    public String reverseWords1(String s) {
        //初始值 不需要判断
        //
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int end = arr.length - 1;
        int start;
        while (end >= 0) {
            if (arr[end] != ' ') {
                //停下end
                start = end - 1;
                while (start >= 0) {
                    if (arr[start] == ' ') {
                        break;
                    }
                    start--;
                }
                //取出其中的单词 [start+1,end+1)
                sb.append(arr, start + 1, end - start);
                sb.append(" ");
                end = start;
            }
            end--;
        }
        return sb.toString().trim();
    }
    
    public String reverseWords(String s) {
        
        StringBuilder sb = new StringBuilder();
        dps(s, sb, 0);
        //
        return sb.toString().trim();
        
    }
    
    private void dps(String s, StringBuilder sb, int start) {
        //去掉空格
        int len = s.length();
        while (start < len && s.charAt(start) == ' ') {
            start++;
        }
        //
        //结束条件
        if (start == len) {
            return;
        }
        //当前层
        int end = start + 1;
        while (end < len && s.charAt(end) != ' ') {
            end++;
        }
        //下一层
        dps(s, sb, end);
        
        //添加
        sb.append(s, start, end).append(" ");
    }
}
