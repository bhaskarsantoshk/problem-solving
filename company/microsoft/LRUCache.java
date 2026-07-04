package company.microsoft;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Node head, tail;
    int capacity;
    Map<Integer, Node> cache;

    class Node{
        int key, value;
        Node prev, next;
        Node ( int key, int value){
            this.key = key;
            this.value = value;
        }
        Node(){
        }
    }
    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        if ( cache.containsKey(key)){
            Node node = cache.get(key);
            delete(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    private void insert(Node node) {
        cache.put(node.key, node);
        Node next = head.next;
        node.next = next;
        next.prev = node;
        node.prev = head;
        head.next = next;
    }

    private void delete(Node node) {
        cache.remove(node.key);
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    public void put(int key, int value) {
        if ( cache.containsKey(key)) delete(cache.get(key));
        if ( cache.size() == capacity) delete(tail.prev);
        Node node = new Node(key, value);
        insert(node);
    }
}
