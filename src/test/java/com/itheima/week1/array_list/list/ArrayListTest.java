package com.itheima.week1.array_list.list;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-17 18:07
 **/
public class ArrayListTest {
    @Test
    public void testB() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("容器内元素为:" + list); // 1‐>2‐>3‐>Null
        System.out.println("容器内元素个数:" + list.size() + "容器是否为空:" + list.isEmpty());
        System.out.println("容器中是否包含3:" + list.contains(3));
        list.add(0, 4);// 4‐>1‐>2‐>3‐>Null
        System.out.println("容器内元素为:" + list);
        list.add(3, 5);//4‐>1‐>2‐>5‐>3‐>Null
        System.out.println("容器内元素为:" + list);
        list.add(2, 6);//4‐>1‐>6‐>2‐>5‐>3‐>Null
        System.out.println("容器内元素为:" + list);
        System.out.println("获取索引为0的元素:" + list.get(0));
        System.out.println("获取索引为5的元素:" + list.get(5));
        System.out.println("获取索引为2的元素:" + list.get(2));
        list.remove(0);//1‐>6‐>2‐>5‐>3‐>Null
        System.out.println("容器内元素为:" + list);
        list.remove(3);//1‐>6‐>2‐>3‐>Null
        System.out.println("移除后容器内元素为:" + list);
        list.clear();
        System.out.println("清空后为:" + list);
    }
    
    @Test
    public void testA() {
        List list = new ArrayList();
        System.out.println(list);
        //添加数据
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("索引为4的元素:" + list.get(4));
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        //再添就要扩容了
        list.add(11);
        System.out.println("size=" + list.size() + "‐‐" + list);
        System.out.println("是否包含8:" + list.contains(8) + ",集合容器是否为空:" + list.isEmpty());
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
//既要扩容，元素又要后移
        list.add(13, 141);
        System.out.println("size=" + list.size() + "‐‐" + list);
        int set = list.set(13, 142);
        System.out.println("set方法返回的值:" + set + "‐‐完成后的list:" + list);
        int remove = list.remove(13);
        System.out.println("remove方法返回的值:" + remove + "‐‐remove后的list:" + list);
        list.clear();
        System.out.println("clear之后:" + list);
    }
}
