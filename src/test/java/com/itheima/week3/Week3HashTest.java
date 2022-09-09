package com.itheima.week3;

import org.junit.Test;

import java.util.*;

/**
 * @program: algo_pro
 * @description: hash的测试类
 * @author: zhanghz001
 * @create: 2021-09-14 15:29
 **/
public class Week3HashTest {
    @Test
    public void test242有效的字母异位词() {
        
        //"aacc"
        // "ccac"
        String s = "aacc";
        String t = "caac";
        System.out.println(isAnagram(s, t));
        //"nl"
        // "cx"
        // String s;
        // s = "nl";
        // String t;
        // t = "cx";
        // System.out.println(isAnagram(s, t));
        // String s = "rat";
        // String t = "car";
        // System.out.println(isAnagram(s, t));
        
        // String s = "anagram";
        // String t = "nagaram";
        // System.out.println(isAnagram(s, t));
        // String s = "rat";
        // String t = "car";
        // System.out.println(isAnagram(s, t));
    }
    
    public boolean isAnagram(String s, String t) {
        //初始值判断
        if (s == null || t == null) {
            return false;
        }
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen) {
            return false;
        }
        //查看其中是否相等
        char[] tarr = t.toCharArray();
        char[] sarr = s.toCharArray();
        int[] array = new int[128];
        for (char value : sarr) {
            array[value]++;
        }
        for (char c : tarr) {
            if (array[c] <= 0) {
                return false;
            } else {
                array[c]--;
            }
        }
        return true;
    }
    
    @Test
    public void test49字母异位词分组() {
        //["eat", "tea", "tan", "ate", "nat", "bat"]
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
    
    @Test
    public void test49字母异位词分组2() {
        //["eat", "tea", "tan", "ate", "nat", "bat"]
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        //初始值判断
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        HashMap<String, List<String>> map = new HashMap<>();
        //建立集合
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        
        //map做好
        return new ArrayList<>(map.values());
        
    }
    
    public List<List<String>> groupAnagrams1(String[] strs) {
        //初始值处理
        if (strs == null) {
            return Collections.emptyList();
        }
        //
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = genKey(str);
            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        
        return new ArrayList<>(map.values());
        
    }
    
    public String genKey(String str) {
        int[] table = new int[26];
        for (int i = 0; i < str.length(); i++) {
            table[str.charAt(i) - 'a']++;
        }
        
        return Arrays.toString(table);
    }
    
    public List<List<String>> groupAnagrams2(String[] strs) {
        //初始值处理
        if (strs == null) {
            return Collections.emptyList();
        }
        //
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = getKey(str);
            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        
        return new ArrayList<>(map.values());
        
    }
    
    private String getKey(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    @Test
    public void test167两数之和() {
        int target = 9;
        int[] numbers = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(numbers, target)));
        
    }
    
    public int[] twoSum(int[] numbers, int target) {
        //初始值判断
        if (numbers == null || numbers.length < 2) {
            return new int[0];
        }
        //需要进行循环
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[0];
    }
    
    @Test
    public void test4寻找两个正序数组的中位数() {
        // int[] nums1 = {1, 3};
        // int[] nums2 = {2};
        // System.out.println(findMedianSortedArrays(nums1, nums2));
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    
    //合并
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //初始值判断
        if (nums1 == null || nums2 == null) {
            return 0;
        }
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        //合并数组
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] nums3 = new int[len];
        int i = 0;
        int j = 0;
        int k = 0;
        for (; k < nums3.length; k++) {
            if (i == len1) {
                nums3[k] = nums2[j];
                j++;
            } else if (j == len2) {
                nums3[k] = nums1[i];
                i++;
            } else if (nums1[i] >= nums2[j]) {
                nums3[k] = nums2[j];
                j++;
            } else if (nums1[i] < nums2[j]) {
                nums3[k] = nums1[i];
                i++;
            }
        }
        if (len % 2 == 0) {
            return ((nums3[len / 2 - 1]) + (nums3[len / 2])) / 2.0;
        } else {
            return nums3[len / 2];
            
        }
        
    }
    
    public class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
        
        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    
    @Test
    public void test23合并K个升序链表() {
        ListNode node11;
        {
            ListNode node3 = new ListNode(5);
            ListNode node2 = new ListNode(4);
            node11 = new ListNode(1);
            node11.next = node2;
            node2.next = node3;
        }
        ListNode node12;
        
        {
            ListNode node3 = new ListNode(4);
            ListNode node2 = new ListNode(3);
            node12 = new ListNode(1);
            node12.next = node2;
            node2.next = node3;
        }
        ListNode node13;
        
        {
            ListNode node2 = new ListNode(6);
            node13 = new ListNode(2);
            node13.next = node2;
        }
        ListNode[] lists = new ListNode[]{node11, node12, node13};
        System.out.println(mergeKLists(lists));
        
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        //初始值判断
        if (lists == null || lists.length == 0) {
            return null;
            
        }
        //哨兵
        ListNode pre = new ListNode(-1);
        ListNode curr = pre;
        
        //需要将头部添加到优先级队列中去
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        return o1.val - o2.val;
                    }
                });
        
        //添加所有头部
        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            }
        }
        //需要进行后续的添加
        ListNode tmp;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            curr.next = tmp;
            curr = curr.next;
            if (tmp.next != null) {
                queue.add(tmp.next);
            }
        }
        
        //
        return pre.next;
    }
    
    @Test
    public void test3无重复字符的最长子串() {
        // String s = "abcabcbb";
        // String s = "abcabcbb";
        // String s = " ";
        // String s = "tmmzuxt";
        String s = "tmmzuxe";
        // String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    
    public int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        while (right < chars.length) {
            char c = chars[right];
            while (set.contains(c)) {
                char l = chars[left];
                set.remove(l);
                left++;
            }
            
            set.add(c);
            
            max = Math.max(max, set.size());
            right++;
        }
        
        return max;
    }
    
    public int lengthOfLongestSubstring(String s) {
        //初始值判断
        if (s == null || s.length() == 0) {
            return 0;
        }
        //需要缓存
        int total = 0;
        int low = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                //重复了,需要重新进行运算
                Integer old = map.get(arr[i]);
                if (old >= low) {
                    //先记录下当前的最大长度. 
                    total = Math.max(total, i - low);
                    low = old + 1;
                } else {
                    //                    
                    total = Math.max(total, i - low + 1);
                }
            } else {
                total = Math.max(total, i - low + 1);
            }
            map.put(arr[i], i);
            // System.out.println("low:" + low + "  ,i: " + i);
            
        }
        return total;
    }
    
    @Test
    public void test76最小覆盖子串() {
        // String s = "ADOBECODEBANC";
        String s = "ADOBBCODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
    
    public String minWindow(String s, String t) {
        //初始值
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        //定义两个hash
        int[] dict = new int[128];
        int[] window = new int[128];
        
        char[] tchars = t.toCharArray();
        for (char tchar : tchars) {
            dict[tchar]++;
        }
        //定义左右边界
        int left = 0;
        int right = 0;
        
        //记录结果的
        int min = s.length() + 1;
        //返回字符串
        String res = "";
        //已经有字典中的字符个数
        int count = 0;
        
        //记录当前窗口中的,和t字符相同的字符
        char[] schars = s.toCharArray();
        while (right < schars.length) {
            char cr = schars[right];
            //
            window[cr]++;
            //判断进入窗口的这个字符是否在c中的,
            if (dict[cr] > 0 && dict[cr] >= window[cr]) {
                //dict[cr] >= window[cr]避免了窗口
                // 中进入了过多的重复字符导致误判,比如t="ABC" 窗口中进入了"AAA"
                count++;
            }
            right++;
            
            //
            while (count == t.length()) {
                //缩小窗口,求最小窗口
                //一个窗口满足条件
                char cl = schars[left];
                if (dict[cl] > 0 && dict[cl] >= window[cl]) {
                    //dict[cl] >= window[cl]这个地
                    // 方避免了移出过多的重复字符导致误判,比如t="ABC" 窗口中有"AABC"
                    count--;
                    if (right - left < min) {
                        min = right - left;
                        res = s.substring(left, right);
                    }
                }
                window[cl]--;
                left++;
                
            }
            
        }
        return res;
    }
    // 滑动窗口模板代码
    // {
    //     int left = 0, right = 0;
    //     // data代表要处理的数据流,window代表我们维护的窗口
    //     while (right < data.size()) {
    //         while (window needs shrink){ //当窗口需要缩小时
    //             //将一些数据移出窗口
    //             window.remove(data[left]);
    //             //左测缩小窗口
    //             left++;
    //             //窗口内数据更新等其他操作
    //             // ......
    //         }
    //        
    //         //向窗口内添加数据-- - 这个步骤有时候需要在前面
    //         window.add(data[right]);
    //        
    //         // 右侧增大窗口
    //         right++;
    //        
    //         //窗口内数据更新等其他操作
    //         // .....
    //     }
    // }
}
