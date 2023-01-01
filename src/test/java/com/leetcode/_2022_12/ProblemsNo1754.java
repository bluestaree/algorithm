package com.leetcode._2022_12;

import org.junit.Test;


/**
 * 1754. 构造字典序最大的合并字符串
 *
 * @author DHW
 * @date 2022/12/24 13:36
 * @Version 1.0
*/
public class ProblemsNo1754 {

    @Test
    public void solution() {
        String word1 = "tpppprrppttppppppppappaprrpp";
        String word2 = "tpptppppppptpppprprtpp";
        System.out.println("res = " + largestMerge1(word1, word2));
    }

    public String largestMerge1(String word1, String word2) {
        StringBuilder merge = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length() && word1.substring(i).compareTo(word2.substring(j)) > 0) {
                merge.append(word1.charAt(i));
                i++;
            } else {
                merge.append(word2.charAt(j));
                j++;
            }
        }
        return merge.toString();
    }


    public String largestMerge(String word1, String word2) {
        char[] chars = new char[word1.length() + word2.length()];
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int index = 0;
        int indexA = 0;
        int indexB = 0;
        while(true){
            if(indexA >= word1.length()) {
                index = buildChars(chars2.length - 1, chars2, index, chars);
                buildChars(indexA -1 , chars1, index, chars);
                break;
            }
            if(indexB >= word2.length()) {
                index = buildChars(chars1.length - 1, chars1, index, chars);
                buildChars(indexB - 1, chars2, index, chars);
                break;
            }
            if(chars1[indexA] > chars2[indexB]) {
                for (int i = indexA + 1; i < chars1.length; i++) {
                    if(chars1[i] > chars2[indexB]) {
                            indexA++;
                    } else {
                        break;
                    }
                }
                index = buildChars(indexA, chars1, index, chars);
                word1 = word1.substring(indexA+1);
                chars1 = word1.toCharArray();
                indexA = 0;
                indexB = 0;
                continue;
            }
            if(chars1[indexA] < chars2[indexB]) {
                for (int i = indexB + 1; i < chars2.length; i++) {
                    if(chars1[indexA] < chars2[i]) {
                        indexB++;
                    } else {
                        break;
                    }
                }
                index = buildChars(indexB, chars2, index, chars);
                word2 = word2.substring(indexB+1);
                chars2 = word2.toCharArray();
                indexA = 0;
                indexB = 0;
                continue;
            }
            indexA++;
            indexB++;
        }
        return new String(chars);
    }

    private int buildChars(int srcIndex, char[] src, int targetIndex, char[] target) {
        for (int i = 0; i <= srcIndex; i++) {
            target[targetIndex] = src[i];
            targetIndex++;
        }
        return targetIndex;
    }
}
