package company.google.design;

import practice.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class P146LRUCache {
    class Node{
        int key, val;
        Node prev, next;
        Node (int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Node head, tail;
    private int capacity;
    Map<Integer, Node> cache;

    P146LRUCache(int capacity){
        this.capacity = capacity;
        this.head = new Node(0,0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.next = head;
        cache = new HashMap<>();
    }

    public int get(int key){
        if ( cache.containsKey(key)){
            Node node = cache.get(key);
            delete(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int val){
        if ( cache.containsKey(key)){
            delete(cache.get(key));
        }
        if ( cache.size() == capacity){
            delete(tail.prev);
        }
        insert(new Node(key, val));
    }

    private void delete(Node node){
        cache.remove(node.key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node){
        cache.put(node.key, node);
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }
}
