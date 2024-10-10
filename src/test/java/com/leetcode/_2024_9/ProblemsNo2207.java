package com.leetcode._2024_9;

import org.junit.Test;


/**
 * 2207. 字符串中最多数目的子序列
 *
 * @author DHW
 * @date 2024/9/24 9:09
 * @Version 1.0
*/
public class ProblemsNo2207 {

    @Test
    public void solution() {
        String text = "vnedkpkkyxelxqptfwuzcjhqmwagvrglkeivowvbjdoyydnjrqrqejoyptzoklaxcjxbrrfmpdxckfjzahparhpanwqfjrpbslsyiwbldnpjqishlsuagevjmiyktgofvnyncizswldwnngnkifmaxbmospdeslxirofgqouaapfgltgqxdhurxljcepdpndqqgfwkfiqrwuwxfamciyweehktaegynfumwnhrgrhcluenpnoieqdivznrjljcotysnlylyswvdlkgsvrotavnkifwmnvgagjykxgwaimavqsxuitknmbxppgzfwtjdvegapcplreokicxcsbdrsyfpustpxxssnouifkypwqrywprjlyddrggkcglbgcrbihgpxxosmejchmzkydhquevpschkpyulqxgduqkqgwnsowxrmgqbmltrltzqmmpjilpfxocflpkwithsjlljxdygfvstvwqsyxlkknmgpppupgjvfgmxnwmvrfuwcrsadomyddazlonjyjdeswwznkaeaasyvurpgyvjsiltiykwquesfjmuswjlrphsdthmuqkrhynmqnfqdlwnwesdmiiqvcpingbcgcsvqmsmskesrajqwmgtdoktreqssutpudfykriqhblntfabspbeddpdkownehqszbmddizdgtqmobirwbopmoqzwydnpqnvkwadajbecmajilzkfwjnpfyamudpppuxhlcngkign";
        String pattern = "rr";
        System.out.println("res = " + maximumSubsequenceCount(text, pattern));
    }

    public long maximumSubsequenceCount(String text, String pattern) {
        char a = pattern.charAt(0);
        char b = pattern.charAt(1);
        int countA = 0;
        int countB = 0;
        long res = 0;
        for (char c : text.toCharArray()) {
            if(c == b) {
                res += countA;
                countB++;
            }
            if(c == a) {
                countA++;
            }
        }
        return res + Math.max(countA, countB);
    }
}

