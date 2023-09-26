package com.jdt.leetcode.demo;

import java.util.HashMap;

/**
 * LRU 最近最少使用的
 *
 * @author jdt
 * @date 2023/8/30
 */
public class LRUTest {

    //1.构造一个Node节点 作为数据载体
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;

        }
    }

    //构造一个虚拟的双向链表，里面存放的是node
    class DoubleLinedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        //添加到头
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;

        }

        //删除节点
        public void removeNode(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;

        }

        //获得最后一个节点
        public Node getLast() {
            return tail.prev;
        }
    }

    int capacity;
    HashMap<Integer, Node<Integer, Integer>> map;
    DoubleLinedList<Integer, Integer> doubleLinedList;


    public LRUTest(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.doubleLinedList = new DoubleLinedList<>();
    }

    public int get(int key) {
        //如果map中存在key
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            //将节点放在头
            doubleLinedList.removeNode(node);
            doubleLinedList.addHead(node);
            return node.value;
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            doubleLinedList.removeNode(node);
            node.value = value;
            doubleLinedList.addHead(node);
            map.put(key, node);
            return;
        }

        //如果当前数据量已经超过容量
        if (map.size() >= capacity) {
            //删除最后的
            Node<Integer,Integer> last = doubleLinedList.getLast();
            doubleLinedList.removeNode(last);
            map.remove(last.key);
        }
        //添加新元素
        Node<Integer, Integer> node = new Node<>(key, value);
        map.put(key, node);
        doubleLinedList.addHead(node);
    }

    public static void main(String[] args) {
        LRUTest lruTest = new LRUTest(3);
        lruTest.put(1,1);
        lruTest.put(2,1);
        lruTest.put(3,1);
        System.out.println(lruTest.map.keySet());
        lruTest.put(4,1);
        System.out.println(lruTest.map.keySet());
    }

}
