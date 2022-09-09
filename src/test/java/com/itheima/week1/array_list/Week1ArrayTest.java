package com.itheima.week1.array_list;

import org.junit.Test;

import java.util.*;

/**
 * @program: algo_pro
 * @description: 数组题目
 * @author: zhanghz001
 * @create: 2021-09-06 14:51
 **/
public class Week1ArrayTest {
    
    //[1,8,6,2,5,4,8,3,7] 
    @Test
    public void test11盛最多水的容器() {
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int max = maxArea(a);
        System.out.println(max);
    }
    
    public int maxArea(int[] height) {
        //初始值判断
        if (height == null || height.length == 0) {
            return 0;
        }
        //其他情况,需要统计最大值,
        //使用双指针的方法
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        
        while (i < j) {
            int ai = height[i];
            int aj = height[j];
            int area = Math.min(ai, aj) * (j - i);
            max = Math.max(max, area);
            if (ai <= aj) {
                // System.out.println("i 前 " + i);
                //对a进行递增
                do {
                    i++;
                } while (height[i] <= ai && i < j);
                // System.out.println("i 后 " + i);
            } else {
                //对b进行递减
                // System.out.println("j 前 " + j);
                do {
                    j--;
                } while (height[j] <= aj && i < j);
                // System.out.println("j 后 " + j);
            }
        }
        return max;
    }
    
    @Test
    public void test283移动零() {
        int[] ints = {0, 1, 0, 3, 12};
        moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }
    
    public void moveZeroes(int[] nums) {
        //初始值判断
        if (nums == null || nums.length == 0) {
            return;
        }
        //需要倒叙遍历,然后替换掉为0的值
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
    
    @Test
    public void test88合并两个有序数组() {
        int[] nums2 = new int[]{2, 5, 6};
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        merge(nums1, 3, nums2, 3);
        
        System.out.println(Arrays.toString(nums1));
        //
        nums1 = new int[]{2, 0};
        nums2 = new int[]{1};
        merge(nums1, 1, nums2, 1);
        
        System.out.println(Arrays.toString(nums1));
        //
        nums1 = new int[]{0};
        nums2 = new int[]{1};
        merge(nums1, 0, nums2, 1);
        
        System.out.println(Arrays.toString(nums1));
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        //初始值判断
        if (n == 0) {
            return;
        }
        
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        
        //初始变量设置
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        //倒数赋值
        do {
            
            if (nums1[i] <= nums2[j]) {
                nums1[k] = nums2[j];
                j--;
                k--;
            } else {
                nums1[k] = nums1[i];
                i--;
                k--;
            }
        } while (j >= 0 && i >= 0);
        if (i < 0) {
            //这时候需要拷贝nums2的[0,j]到nums1中
            System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
    }
    
    @Test
    public void test15三数之和() {
        int[] numbers = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(numbers));
        numbers = new int[]{0, 0, 0};
        System.out.println(threeSum(numbers));
        
    }
    
    public List<List<Integer>> threeSum1(int[] nums) {
        //初值判断
        if (nums == null || nums.length < 3) {
            return Collections.EMPTY_LIST;
        }
        //排序
        Arrays.sort(nums);
        
        //返回值
        List<List<Integer>> res = new ArrayList<>();
        //需要采用a,b,c三个数,中a固定,b,c双指针的方式,还要缓存
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length - 2; ) {
            int j = i + 1;
            int k = nums.length - 1;
            do {
                if (nums[j] + nums[k] + nums[i] == 0) {
                    List<Integer> list = new ArrayList<>();
                    //记下来
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    do {
                        k--;
                    } while (nums[k + 1] == nums[k] && j < k);
                    do {
                        j++;
                    } while (nums[j - 1] == nums[j] && j < k);
                    
                } else if (nums[j] + nums[k] + nums[i] > 0) {
                    //大了,需要k--
                    do {
                        k--;
                    } while (nums[k + 1] == nums[k] && j < k);
                } else if (nums[j] + nums[k] + nums[i] < 0) {
                    //小了,需要j++
                    do {
                        j++;
                    } while (nums[j - 1] == nums[j] && j < k);
                }
            } while (j < k);
            do {
                i++;
            } while (nums[i - 1] == nums[i] && i < (nums.length - 2));
        }
        return res;
    }
    
    public List<List<Integer>> threeSum2(int[] nums) {
        //初始值判断
        if (nums == null) {
            return Collections.emptyList();
        }
        int len = nums.length;
        if (len <= 2) {
            return Collections.emptyList();
        }
        //排序
        Arrays.sort(nums);
        //
        int sum;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            //跳过重复项
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int bIdx = i + 1;
            int cIdx = len - 1;
            while (bIdx < cIdx) {
                sum = nums[i] + nums[bIdx] + nums[cIdx];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[bIdx]);
                    list.add(nums[cIdx]);
                    list.sort(Comparator.naturalOrder());
                    lists.add(list);
                    while (bIdx < cIdx && nums[bIdx] == nums[bIdx + 1]) {
                        bIdx++;
                    }
                    bIdx++;
                    while (bIdx < cIdx && nums[cIdx] == nums[cIdx - 1]) {
                        cIdx--;
                    }
                    cIdx--;
                } else if (sum < 0) {
                    while (bIdx < cIdx && nums[bIdx] == nums[bIdx + 1]) {
                        bIdx++;
                    }
                    bIdx++;
                    //
                } else {
                    while (bIdx < cIdx && nums[cIdx] == nums[cIdx - 1]) {
                        cIdx--;
                    }
                    cIdx--;
                }
            }
        }
        return lists;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        //特殊判断
        if (nums == null || nums.length < 3) {
            return Collections.EMPTY_LIST;
        }
        
        Set<List<Integer>> res = new HashSet<>();
        //把三个数的和变成两个数的和
        for (int i = 0; i < nums.length - 2; i++) {
            int sum = -nums[i];
            HashMap<Integer, Integer> cache = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                //如果有匹配的值
                if (cache.containsKey(sum - nums[j])) {
                    //就加入到返回值中
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(sum - nums[j]);
                    list.sort(Comparator.naturalOrder());
                    res.add(list);
                } else {
                    //存储起来
                    cache.put(nums[j], j);
                }
                
            }
        }
        
        return new ArrayList<>(res);
        
    }
    
    @Test
    public void test66加一() {
        int[] digits = new int[]{1, 2, 3};
        int[] ints = plusOne(digits);
        System.out.println(Arrays.toString(digits));
    }
    
    public int[] plusOne(int[] digits) {
        //初值判断
        if (digits == null || digits.length == 0) {
            return null;
        }
        //需要加一,考虑进位
        int j = digits.length - 1;
        do {
            if (digits[j] + 1 == 10) {
                //需要进位
                digits[j] = 0;
                j--;
            } else {
                //不需要进位
                digits[j] = digits[j] + 1;
                return digits;
            }
        } while (j >= 0);
        //说明最后一位需要进位 类似于[9,9] 进位成[1,0,0]
        int[] dig = new int[digits.length + 1];
        dig[0] = 1;
        return dig;
    }
    
    @Test
    public void test9回文数() {
        System.out.println(isPalindrome(12211));
    }
    
    public boolean isPalindrome(int x) {
        //初值判断
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else if (x % 10 == 0) {
            return false;
        } else {
            //将x的后半段翻转，构造一个新的数和x前半段比较
            int revertNum = 0;
            while (x > revertNum) { //x的位数在缩小, revertNum的位数在增大
                revertNum = revertNum * 10 + x % 10;
                x = x / 10;
            }
            return x == revertNum || x == revertNum / 10;
        }
    }
    
    @Test
    public void test1两数之和() {
        int[] ints = twoSum(new int[]{10, 2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }
    
    public int[] twoSum(int[] nums, int target) {
        //初始值判断
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        //通过HashMap缓存
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(target - nums[i])) {
                return new int[]{cache.get(target - nums[i]), i};
            }
            cache.put(nums[i], i);
        }
        
        return new int[0];
    }
    
    public java.util.List<java.util.List<Integer>> fourSum1(int[] nums, int target) {
        //初始值判断
        if (nums == null) {
            return Collections.emptyList();
        }
        int len = nums.length;
        if (len < 4) {
            return Collections.emptyList();
        }
        
        //排序
        Arrays.sort(nums);
        // logger.info("logger  " + Arrays.toString(nums));
        // System.out.println(Arrays.toString(nums));
        //返回值
        java.util.List<java.util.List<Integer>> lists = new java.util.ArrayList<>();
        
        //循环
        int ai1;
        int ai2;
        int ai3;
        int ai4;
        for (int i1 = 0; i1 < len - 3; i1++) {
            ai1 = nums[i1];
            if (nums[i1] + nums[i1 + 1] + nums[i1 + 2] + nums[i1 + 3] > target) {
                break;
            }
            if (nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4] < target) {
                break;
            }
            if (i1 > 0 && nums[i1 - 1] == ai1) {
                continue;
            }
            // System.out.println("i1: " + i1 + " ai1: " + ai1 + "=========1111111111111111111=====");
            //
            int sum = target - ai1;
            for (int i2 = i1 + 1; i2 < len - 2; i2++) {
                ai2 = nums[i2];
                int min = ai1 + ai2 + nums[i2 + 1] + nums[i2 + 2];
                int max = ai1 + nums[len - 3] + nums[len - 2] + nums[len - 1];
                if (min > target || max < target) {
                    break;
                }
                if (i2 > i1 + 1 && nums[i2 - 1] == ai2) {
                    continue;
                }
                
                //i3和i4的夹逼
                
                // System.out.println("i2: " + i2 + " ai2: " + ai2 + "===22222222=");
                int i3 = i2 + 1;
                int i4 = len - 1;
                //i2和i4循环
                while (i3 < i4) {
                    ai3 = nums[i3];
                    ai4 = nums[i4];
                    
                    //
                    // sum234
                    int sum234 = ai2 + ai3 + ai4;
                    // System.out.println("i3: " + i3 + " ai3: " + ai3 + "======" +
                    //         "i4: " + i4 + " ai4: " + ai4 + "===== sum:" + sum +
                    //         "==== sum234:" + sum234);
                    if (sum234 == sum) {
                        java.util.List<Integer> list = new java.util.ArrayList<>();
                        list.add(ai1);
                        list.add(ai2);
                        list.add(ai3);
                        list.add(ai4);
                        lists.add(list);
                        while (i3 < i4 && nums[i3 + 1] == ai3) {
                            i3++;
                        }
                        while (i3 < i4 && nums[i4 - 1] == ai4) {
                            i4--;
                        }
                        //
                        i3++;
                        i4--;
                    } else if (sum234 < sum) {
                        while (i3 < i4 && nums[i3 + 1] == ai3) {
                            i3++;
                        }
                        i3++;
                    } else {
                        while (i3 < i4 && nums[i4 - 1] == ai4) {
                            i4--;
                        }
                        i4--;
                    }
                }
            }
            
        }
        
        return lists;
    }
    
    @Test
    public void test18四数之和() {
        // System.out.println(fourSum(new int[]{34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15, 21, -43,
        //         57, -6, 86, 56, 94, 74, 83, -14, 28, -66, 46, -49,
        //         62, -11, 43, 65, 77, 12, 47, 61, 26, 1, 13, 29, 55,
        //         -82, 76, 26, 15, -29, 36, -29, 10, -70, 69, 17, 49}, 0));
        // int[] ints = {1, -2, -5, -4, -3, 3, 3, 5};
        int[] ints = {-1, 0, 1, 2, -1, -4};
        System.out.println(fourSum(ints, -1));
        // int[] ints1 = {0, 0, 0, 0};
        // System.out.println(fourSum(ints1, 0));
    }
    
    //四数之和
    
    public java.util.List<java.util.List<Integer>>
    fourSum(int[] nums, int target) {
        //初始值判断
        if (nums == null || nums.length < 4) {
            return Collections.EMPTY_LIST;
        }
        //排序
        Arrays.sort(nums);
        
        //处理极值
        if (nums[nums.length - 1] + nums[nums.length - 2]
                + nums[nums.length - 3] + nums[nums.length - 4] < target) {
            return Collections.EMPTY_LIST;
        }
        //为了担心重复,还是需要防重的
        Set<List<Integer>> res = new HashSet<>();
        
        //需要进行双循环 ai1,ai2,里面套用ai3,ai4用双指针紧逼
        for (int i1 = 0; i1 < nums.length - 3; i1++) {
            
            int ai1 = nums[i1];
            //需要进行剪枝跳过重复的
            if (i1 > 0 && nums[i1 - 1] == ai1) {
                continue;
            }
            //需要进最大和最小值的剪枝
            if (ai1 + nums[i1 + 1] + nums[i1 + 2] + nums[i1 + 3] > target) {
                break;
            }
            
            if (nums[nums.length - 1] + nums[nums.length - 2]
                    + nums[nums.length - 3] + ai1 < target) {
                continue;
            }
            
            for (int i2 = i1 + 1; i2 < nums.length - 2; i2++) {
                int ai2 = nums[i2];
                if (i2 > i1 + 1 && nums[i2 - 1] == ai2) {
                    continue;
                }
                
                //需要判断最大和最小的情况是否需要剪枝
                int max = ai1 + ai2 + nums[nums.length - 2] + nums[nums.length - 1];
                int min = ai1 + ai2 + nums[i2 + 1] + nums[i2 + 2];
                if (max < target) {
                    //剪枝,i2循环,ai2会增加的,所以用continue
                    continue;
                }
                if (min > target) {
                    //剪枝 ,i2循环,min只会越来越大
                    break;
                }
                
                //ai3,ai4用双指针紧逼
                int i3 = i2 + 1;
                int i4 = nums.length - 1;
                do {
                    int ai3 = nums[i3];
                    int ai4 = nums[i4];
                    int sum = ai1 + ai2 + ai3 + ai4;
                    if (sum == target) {
                        //进行记录
                        List<Integer> list = new ArrayList<>();
                        list.add(ai1);
                        list.add(ai2);
                        list.add(ai3);
                        list.add(ai4);
                        res.add(list);
                        
                        //需要进行i4和i3的移位
                        do {
                            i4--;
                        } while (i3 < i4 && ai4 == nums[i4]);
                        do {
                            i3++;
                        } while (i3 < i4 && ai3 == nums[i3]);
                    } else if (sum > target) {
                        // i4--
                        do {
                            i4--;
                        } while (i3 < i4 && ai4 == nums[i4]);
                        
                    } else if (sum < target) {
                        // i3++
                        do {
                            i3++;
                        } while (i3 < i4 && ai3 == nums[i3]);
                    }
                } while (i3 < i4);
            }
        }
        
        //返回
        return new ArrayList<>(res);
    }
    
    @Test
    public void testLCP18早餐组合() {
        //staple = [10,20,5], drinks = [5,5,2], x = 15
        // int x = 15;
        // int[] drinks = {5, 5, 2};
        // int[] staple = {10, 20, 5};
        // int i = breakfastNumber(staple, drinks, x);
        int x = 15;
        // int x = 10;
        // int[] drinks = {5, 5, 2};
        int[] drinks = {5, 5, 2, 10, 10, 11};
        // int[] drinks = {5, 5, 2,10,10,11,12};
        int[] staple = {10, 20, 5};
        int i = breakfastNumber(staple, drinks, x);
        System.out.println(i);
    }
    
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        //初始值判断
        if (staple == null || staple.length == 0) {
            return 0;
        }
        if (drinks == null || drinks.length == 0) {
            return 0;
        }
        
        //排序
        Arrays.sort(staple);
        Arrays.sort(drinks);
        
        int res = 0;
        //需要进行双指针逼近
        int i = 0;
        int j = drinks.length - 1;
        do {
            //过程中就需要进行 res % 1000000007
            int ai = staple[i];
            int bj = drinks[j];
            if (ai + bj <= x) {
                res = (res + j + 1) % 1000000007;
                i++;
                //剪枝,去掉大的,但是去掉,感觉更加浪费时间,因为正常的对比也要耗费性能
                // if (i < staple.length && (staple[i] + drinks[0]) > x) {
                //     break;
                // }
            } else {
                //下降的时候用二分法快一些
                j--;
            }
            
        } while (i < staple.length && j >= 0);
        
        return res % 1000000007;
    }
    
    private static int binarySearch0(long[] a, int fromIndex, int toIndex,
                                     long key) {
        int low = fromIndex;
        int high = toIndex - 1;
        
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid];
            
            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
    
    public int breakfastNumber1(int[] staple, int[] drinks, int x) {
        //初始值判断
        if (staple == null || drinks == null) {
            return 0;
        }
        int slen = staple.length;
        int dlen = drinks.length;
        if (dlen == 0 || slen == 0) {
            return 0;
        }
        
        //排序
        Arrays.sort(staple);
        Arrays.sort(drinks);
        // System.out.println(Arrays.toString(staple));
        // System.out.println(Arrays.toString(drinks));
        //
        int ai1;
        int ai2;
        int sum = 0;
        int i1 = 0;
        int i2 = dlen - 1;
        while (i1 < slen && i2 >= 0) {
            ai1 = staple[i1];
            int target = x - ai1;
            ai2 = drinks[i2];
            if (ai2 <= target) {
                // System.out.println("ai1: " + ai1 + " i1: " + i1 + "========");
                //记下值
                int index = i2 + 1;
                sum += index;
                sum = sum % 1000000007;
                i1++;
            } else {
                //还可以在进行二分查找,不需要多次循环,而是一次就找到i2应该的位置
                int low = binarySearch0(drinks, 0, i2, target);
                
                // System.out.println(" i2: " + i2 + " ai2: " + ai2 + " target: " + target +
                //         "  low: " + low);
                
                // if (i2 == 0) {
                //     break; // i2--;
                // } else {
                //     i2 = low;
                // }
                i2--;
            }
        }
        
        return sum;
    }
    
    private static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex;
        
        while (1 < high - low) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];
            
            if (midVal <= key)
                low = mid;
            else
                high = mid;
            // key found
        }
        return low;  // key not found.
    }
    
    @Test
    public void test26删除有序数组中的重复项() {
        //给定数组 nums = [1,1,2],
        // 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2
        
        // int[] nums = new int[]{1, 1, 2};
        // int i = removeDuplicates(nums);
        // System.out.println(i);
        // System.out.println(Arrays.toString(nums));
        //给定 nums = [0,0,1,1,1,2,2,3,3,4],
        //
        // 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
        //
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }
    
    public int removeDuplicates(int[] nums) {
        //初始值判断
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //有序数组,不需要排序,直接开搞
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
    
    @Test
    public void test189旋转数组() {
        //输入: [1,2,3,4,5,6,7] 和 k = 3
        // 输出: [5,6,7,1,2,3,4]
        // 解释:
        // 向右旋转 1 步: [7,1,2,3,4,5,6]
        // 向右旋转 2 步: [6,7,1,2,3,4,5]
        // 向右旋转 3 步: [5,6,7,1,2,3,4]
        
        // int k = 3;
        // int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        int[] nums = {1, 2};
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
        //输入: [-1,-100,3,99] 和 k = 2
        // 输出: [3,99,-1,-100]
        // 解释:
        // 向右旋转 1 步: [99,-1,-100,3]
        // 向右旋转 2 步: [3,99,-1,-100]
        //
        
        // int k = 3;
        // int[] nums = {-1, -100, 3, 99};
        // rotate(nums, k);
        // System.out.println(Arrays.toString(nums));
    }
    
    public void rotate(int[] nums, int k) {
        //初始值判断
        if (nums == null) {
            return;
        }
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        //需要对k取模        
        k = k % n;
        if (k <= 0) {
            return;
        }
        //k>0移动,需要进行反转    
        int i = 0;
        int j = n - 1;
        reverse2(nums, i, j);
        i = 0;
        j = k - 1;
        reverse2(nums, i, j);
        i = k;
        j = n - 1;
        reverse2(nums, i, j);
        
    }
    
    private void reverse2(int[] nums, int i, int j) {
        while (i < j) {
            //交互值
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            //
            i++;
            j--;
        }
    }
    
}
