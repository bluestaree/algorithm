package com.leetcode._2024_10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 1436. 旅行终点站
 *
 * @author DHW
 * @date 2024/10/8 9:22
 * @Version 1.0
 */
public class ProblemsNo1436 {

    @Test
    public void solution() {
        List<List<String>> paths = new ArrayList<>();
        List<String> s1 = new ArrayList<>();
        s1.add("London");
        s1.add("New York");
        paths.add(s1);
        System.out.println("res = " + destCity(paths));
    }

    public String destCity(List<List<String>> paths) {
        Set<String> setA = new HashSet<>(paths.size());
        for (List<String> p : paths) {
            setA.add(p.get(0));
        }

        for (List<String> p : paths) {
            if (!setA.contains(p.get(1))) {
                return p.get(1);
            }
        }
        return "";
    }
}

