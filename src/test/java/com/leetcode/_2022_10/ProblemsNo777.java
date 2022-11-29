package com.leetcode._2022_10;

import org.junit.Test;


/**
 * 777. 在LR字符串中交换相邻字符
 *
 * @author DHW
 * @date 2022/10/2 12:50
 * @Version 1.0
*/
public class ProblemsNo777 {

    @Test
    public void solution() {
//        String start = "RXXLRXRXL";
//        String end =   "RXRLRRXRX";
        String start = "LXXLRXRXL";
        String end =   "XLLXXRRLX";
        System.out.println("end = " + canTransform1(start, end));
    }

    public boolean canTransform(String start, String end) {
        char[] startChars = start.toCharArray();
        char[] endChars = end.toCharArray();
        for (int i = 0; i < endChars.length; i++) {
            if(startChars[i] == endChars[i]) {
                continue;
            }
            if(!tryTransform(startChars, endChars[i], i)) {
                return false;
            }
        }
        return true;
    }

    private boolean tryTransform(char[] startChars, char targetChar, int i) {
        for (int j = i + 1; j < startChars.length; j++) {
            if(startChars[j] == targetChar) {
                transform(startChars, j, i);
                return true;
            }
        }
        return false;
    }

    private void transform(char[] startChars, int j, int i) {
        char temp;
        while (i != j) {
            temp = startChars[j - 1];
            startChars[j - 1] = startChars[j];
            startChars[j] = temp;
            j--;
        }
    }

    public boolean canTransform1(String start, String end) {
        char c1[]=start.toCharArray(),c2[]=end.toCharArray();
        int p1=0,p2=0;
        while(p1<c1.length&&p2<c1.length){
            while(p1<c1.length&&c1[p1]=='X'){p1++;}
            while(p2<c1.length&&c2[p2]=='X'){p2++;}
            if(p1==p2&&p1==c1.length){return true;}
            if(p1==c1.length||p2==c2.length||c1[p1]!=c2[p2]){return false;}
            if(c1[p1]=='L'){if(p1<p2){return false;}}
            else if(p1>p2){return false;}
            p1++;
            p2++;
        }
        for(int i=p1;i<c1.length;i++){if(c1[i]!='X'){return false;}}
        for(int i=p2;i<c1.length;i++){if(c2[i]!='X'){return false;}}
        return true;
    }
}
