package com.leetcode._2023_3;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;


/**
 * 面试题 17.05. 字母与数字
 *
 * @author DHW
 * @date 2023/3/11 11:32
 * @Version 1.0
*/
public class ProblemsNo1705 {

    @Test
    public void solution() {
        String[] array = new String[]{"42","10","O","t","y","p","g","B","96","H","5","v","P","52","25","96","b","L","Y","z","d","52","3","v","71","J","A","0","v","51","E","k","H","96","21","W","59","I","V","s","59","w","X","33","29","H","32","51","f","i","58","56","66","90","F","10","93","53","85","28","78","d","67","81","T","K","S","l","L","Z","j","5","R","b","44","R","h","B","30","63","z","75","60","m","61","a","5","S","Z","D","2","A","W","k","84","44","96","96","y","M"};
        System.out.println("res = " + findLongestSubarray1(array));
    }

    public String[] findLongestSubarray(String[] array) {
        int[] s = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            int k = array[i].charAt(0) >= 'A' ? 1 : -1;
            s[i + 1] = s[i] + k;
        }

        int begin = 0;
        int end = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= array.length; i++) {
            Integer j = map.getOrDefault(s[i], -1);
            if(j < 0) {
                map.put(s[i], i);
            } else if(i - j > end - begin) {
                end = i;
                begin = j;
            }
        }

        String[] res = new String[end - begin];
        System.arraycopy(array, begin, res, 0, res.length);
        return res;
    }

    public String[] findLongestSubarray1(String[] array) {
        int n = array.length;
        int s = n;
        int begin = 0;
        int end = 0;
        int[] first = new int[2*n + 1];
        Arrays.fill(first, -1);
        first[s] = 0; // s[0] = 0
        for (int i = 1; i <= n; i++) {
            int k = array[i - 1].charAt(0) >= 'A' ? 1 : -1;
            s += k;
            int j = first[s];
            if(j < 0) {
                first[s] = i;
            } else if(i - j > end - begin) {
                end = i;
                begin = j;
            }
        }

        String[] res = new String[end - begin];
        System.arraycopy(array, begin, res, 0, res.length);
        return res;
    }
}
