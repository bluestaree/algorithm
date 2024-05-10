package com.leetcode._2024_4;

import org.junit.Test;

import java.util.*;


/**
 * 1600. 王位继承顺序
 *
 * @author DHW
 * @date 2024/4/7 10:07
 * @Version 1.0
 */
public class ProblemsNo1600 {

    @Test
    public void solution() {
        ThroneInheritance obj = new ThroneInheritance("kingName");
        obj.birth("kingName", "childName");
        obj.death("childName");
        List<String> param_3 = obj.getInheritanceOrder();
        System.out.println("res = " + param_3);
    }

    class ThroneInheritance {

        Map<String, List<String>> map;
        Set<String> set;
        String kingName;

        public ThroneInheritance(String kingName) {
            this.kingName = kingName;
            map = new HashMap();
            set = new HashSet<>();
            map.put(kingName, new ArrayList<>());
        }

        public void birth(String parentName, String childName) {
            List list = map.getOrDefault(parentName, new ArrayList());
            list.add(childName);
            map.put(parentName, list);
        }

        public void death(String name) {
            set.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> res = new ArrayList<>();
            successor(kingName, res);
            return res;
        }

        private void successor(String x, List<String> curOrder) {
            if(!set.contains(x)) {
                curOrder.add(x);
            }
            List<String> list = map.get(x);
            if(list != null && list.size() > 0) {
                for (String s : list) {
                    successor(s, curOrder);
                }
            }
        }
    }

}

