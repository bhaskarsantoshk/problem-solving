package company.apple;

import java.util.HashMap;
import java.util.Map;

public class P52LRUCache {
    // map to store key and value ( could be an object )
    // you need to keep moving left and right to store last recently used
    // arrays work but it will be complex operation
    // linkedlist
    // head -(cache)- tail
    // add it at head for new entries - LRU oder maintains
    // remove from end when it reaches capacity

    class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value){
            this.value= value;
            this.key = key;
        }
        Node(){
        }
    }

    Map<Integer, Node> cache;
    Node head, tail;
    int capacity;


    P52LRUCache(int capacity){
        this.cache = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    // put
    // get
    // delete
    // insert


    public void put(int key, int val){
        if ( cache.containsKey(key)){
            delete(cache.get(key));
        }
        if ( cache.size() == capacity){
            delete(tail.prev);
        }
        insert(new Node(key, val));
    }

    // head - cache

    private void insert(Node node) {
        cache.put(node.key, node);
        Node next = head.next;
        node.next = next;
        next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void delete(Node node) {
        cache.remove(node.key);
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    public int get(int key){
        if ( cache.containsKey(key)){
            Node node = cache.get(key);
            delete(node);
            insert(node);
            return cache.get(key).value;
        }
        return -1;
    }
}
