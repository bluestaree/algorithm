package com.leetcode._2024_7;

import org.junit.Test;

import java.util.*;


/**
 * 721. 账户合并
 *
 * @author DHW
 * @date 2024/7/15 9:11
 * @Version 1.0
*/
public class ProblemsNo721 {

    @Test
    public void solution() {
        List<List<String>> accounts = new ArrayList<>();
        List<String> account1 = new ArrayList<>();
        account1.add("David");
        account1.add("Avid0@m.co");
        account1.add("David0@m.co");
        account1.add("David1@m.co");
        accounts.add(account1);
        List<String> account2 = new ArrayList<>();
        account2.add("David");
        account2.add("Gvid3@m.co");
        account2.add("David3@m.co");
        account2.add("David4@m.co");
        accounts.add(account2);
        List<String> account3 = new ArrayList<>();
        account3.add("David");
        account3.add("David4@m.co");
        account3.add("David5@m.co");
        accounts.add(account3);
        List<String> account4 = new ArrayList<>();
        account4.add("David");
        account4.add("David2@m.co");
        account4.add("David3@m.co");
        accounts.add(account4);
        List<String> account5 = new ArrayList<>();
        account5.add("David");
        account5.add("David1@m.co");
        account5.add("David2@m.co");
        accounts.add(account5);
        System.out.println("res = " + accountsMerge(accounts));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, List<TreeSet<String>>> map = new HashMap<>();
        for (List<String> account : accounts) {
            checkAndMerge(map, account);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<TreeSet<String>>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<TreeSet<String>> value = entry.getValue();
            for (TreeSet<String> treeSet : value) {
                List<String> list = new ArrayList<>();
                list.add(key);
                list.addAll(treeSet);
                res.add(list);
            }
        }
        return res;
    }

    private void checkAndMerge(HashMap<String, List<TreeSet<String>>> map, List<String> account) {
        List<TreeSet<String>> treeSets = map.getOrDefault(account.get(0), new ArrayList<>());
        ArrayList<TreeSet<String>> list = new ArrayList();
        Iterator<TreeSet<String>> iterator = treeSets.iterator();
        while(iterator.hasNext()) {
            TreeSet<String> next = iterator.next();
            for (int j = 1; j < account.size(); j++) {
                if(next.contains(account.get(j))) {
                    list.add(next);
                    iterator.remove();
                    break;
                }
            }
        }
        if(list.size() >= 1) {
            TreeSet<String> mergeSet = new TreeSet<>();
            for (TreeSet<String> treeSet : list) {
                mergeSet.addAll(treeSet);
            }
            merge(mergeSet, account);
            treeSets.add(mergeSet);
            return;
        }

        TreeSet<String> treeSet = new TreeSet<>();
        merge(treeSet, account);
        treeSets.add(treeSet);
        map.put(account.get(0), treeSets);
    }

    private void merge(TreeSet<String> treeSet, List<String> account) {
        for (int i = 1; i < account.size(); i++) {
            treeSet.add(account.get(i));
        }
    }
}

