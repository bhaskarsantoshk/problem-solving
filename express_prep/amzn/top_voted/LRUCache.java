package express_prep.amzn.top_voted;

import java.util.HashMap;

public class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        Node ( int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node(0,0);
    Node tail = new Node(0, 0);

    int capacity;
    HashMap<Integer, Node> cache = new HashMap<>();

    public LRUCache(){
    }

    public LRUCache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if ( cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    private void remove(Node node) {
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        cache.put(node.key, node);
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    public void put( int key, int value){
        if ( cache.containsKey(key)){
            remove(cache.get(key));
        }
        if ( cache.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
}
