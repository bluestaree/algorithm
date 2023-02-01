package com.leetcode._2023_1;

import org.junit.Test;


/**
 * 1813. 句子相似性 III
 *
 * @author DHW
 * @date 2023/1/16 9:32
 * @Version 1.0
*/
public class ProblemsNo1813 {

    @Test
    public void solution() {
//        String sentence1 = "CwFfRo regR";
//        String sentence2 = "CwFfRo H regR";
//        String sentence1 = "A B C D B B";
//        String sentence2 = "A B B";
        String sentence1 = "c h p Ny";
        String sentence2 = "c BDQ r h p Ny";
        System.out.println("res = " + areSentencesSimilar(sentence1, sentence2));
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] split1 = sentence1.split(" ");
        String[] split2 = sentence2.split(" ");

        String[] src;
        String[] target;
        if(sentence1.length() < sentence2.length()) {
            src = split1;
            target = split2;
        } else {
            src = split2;
            target = split1;
        }
        return check(src, target);
    }

    private boolean check(String[] src, String[] target) {

        int num = 0;
        for (int i = 0; i < src.length; i++) {
            if(!src[i].equals(target[i])) {
                break;
            }
            num++;
        }

        if(num == src.length) { return true;}

        int index = num;
        for (int i = src.length - 1, j = target.length - 1; i >= index && j >= 0; i--,j--) {
            if(!src[i].equals(target[j])) {
                break;
            }
            num++;
        }

        return num == src.length;
    }
}
