package com.jdt.leetcode.demo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jdt
 * @date 2023/8/30
 */
public class LinkedHashMapLRUDemo<K, V> extends LinkedHashMap<K, V> {

    private int capacity;//缓存坑位

    public LinkedHashMapLRUDemo(int capacity) {
        //accessOrder-true: 根据访问顺序
        //accessOrder-false:根据插入顺序
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LinkedHashMapLRUDemo demo = new LinkedHashMapLRUDemo(3);
        demo.put(1,"a");
        demo.put(2,"b");
        demo.put(3,"c");
        System.out.println(demo.keySet());
        demo.put(4,"c");
        System.out.println(demo.keySet());

    }
}
