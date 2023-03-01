package com.leetcode._2023_2;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * 1797. 设计一个验证系统
 *
 * @author DHW
 * @date 2023/2/9 16:29
 * @Version 1.0
*/
public class ProblemsNo1797 {

    @Test
    public void solution() {
    }

    class AuthenticationManager {

        HashMap<String, Integer> map;
        int timeToLive;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            this.map = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            Integer generateTime = map.get(tokenId);
            if(generateTime == null || currentTime >= generateTime) {
                map.remove(tokenId);
                return;
            }
            map.put(tokenId, currentTime + timeToLive);
        }

        public int countUnexpiredTokens(int currentTime) {
            int num = 0;
            Iterator<Map.Entry<String, Integer>> entryIterator = map.entrySet().iterator();
            while (entryIterator.hasNext()) {
                Map.Entry<String, Integer> entry = entryIterator.next();
                Integer value = entry.getValue();
                if(value > currentTime) {
                    num++;
                } else {
                    entryIterator.remove();
                }
            }
            return num;
        }
    }
}
