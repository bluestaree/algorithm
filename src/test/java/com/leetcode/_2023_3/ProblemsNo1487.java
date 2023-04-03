package com.leetcode._2023_3;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;


/**
 * 1487. 保证文件名唯一
 *
 * @author DHW
 * @date 2023/3/3 10:45
 * @Version 1.0
*/
public class ProblemsNo1487 {

    @Test
    public void solution() {
        String[] names = new String[]{"r(1)","r","r(2)(1)","r(1)","r","r","r(2)","r(2)(1)","r"};
        System.out.println("res = " + getFolderNames(names));
    }

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> index = new HashMap<String, Integer>();
        int n = names.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (!index.containsKey(name)) {
                res[i] = name;
                index.put(name, 1);
            } else {
                int k = index.get(name);
                while (index.containsKey(addSuffix(name, k))) {
                    k++;
                }
                res[i] = addSuffix(name, k);
                index.put(name, k + 1);
                index.put(addSuffix(name, k), 1);
            }
        }
        return res;
    }

    public String addSuffix(String name, int k) {
        return name + "(" + k + ")";
    }
}
