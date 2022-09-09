package com.itheima.week3.hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-02-26 13:15
 **/
public class
Hash {
    //服务器列表
    private static String[] servers = {"192.168.0.1",
            "192.168.0.2", "192.168.0.3", "192.168.0.4"};
    
    private static SortedMap<Integer, String> serverMap = new TreeMap<>();
    
    static {
        for (int i = 0; i < servers.length; i++) {
            String server = servers[i];
            int hash = getHash(server);
            //理论上，hash环的最大值为2^32
            //这里为做实例，将ip末尾作为上限也就是254
            //那么服务器是0‐4，乘以60后可以均匀分布到 0‐254 的环上去
            //实际的请求ip到来时，在环上查找即可
            hash *= 60;
            System.out.println("add" + server + ", hash=" + hash);
            serverMap.put(hash, server);
        }
    }
    
    private static int getHash(String server) {
        int idx = server.lastIndexOf(".");
        String s = server.substring(idx + 1);
        return Integer.parseInt(s);
    }
    
    private static String getServer(String ip) {
        int hash = getHash(ip);
        SortedMap<Integer, String> tailMap = serverMap.tailMap(hash);
        if (tailMap.isEmpty()) {
            Integer i = serverMap.firstKey();
            return serverMap.get(i);
        } else {
            Integer i = tailMap.firstKey();
            return tailMap.get(i);
        }
    }
    
    public static void main(String[] args) {
        //模拟5个随机ip请求
        for (int i = 1; i < 8; i++) {
            String ip = "192.168.1." + i * 30;
            System.out.println(ip + " ‐‐‐> " + getServer(ip));
        } //将5号服务器加到2‐3 之间，取中间位置，150
        System.out.println("add 192.168.0.5，hash=150");
        serverMap.put(150, "192.168.0.5");
        //再次发起5个请求
        for (int i = 1; i < 8; i++) {
            String ip = "192.168.1." + i * 30;
            System.out.println(ip + " ‐‐‐> " + getServer(ip));
        }
    }
    
}
