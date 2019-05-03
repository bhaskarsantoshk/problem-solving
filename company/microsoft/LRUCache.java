package microsoft;

import java.util.Hashtable;

public class LRUCache {
    private Hashtable<Integer, DListNode> cache = new Hashtable<>();
    private int count;
    private int capacity;
    private DListNode head, tail;


    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new DListNode();
        head.prev = null;
        tail= new DListNode();
        tail.next = null;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DListNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        this.moveToHead(node);
        return node.value;
    }

    private void moveToHead(DListNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private void removeNode(DListNode node) {
        DListNode prev = node.prev;
        DListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }


    public void set(int key, int value) {
        DListNode node = cache.get(key);
        if(node == null){
            DListNode newNode = new DListNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            ++count;

            if(count> capacity){
                DListNode toBeDeletedNode= this.popTail();
                this.cache.remove(toBeDeletedNode.key);
                --count;
            }
        }
        else{
            node.value = value;
            this.moveToHead(node);
        }
    }

    private DListNode popTail() {
        DListNode result = tail.prev;
        this.removeNode(result);
        return result;
    }

    class DListNode{
        int key;
        int value;
        DListNode prev;
        DListNode next;
    }

    private void addNode(DListNode node){
        node.prev = head;
        node.next= head.next;
        head.next.prev= node;
        head.next= node;
    }
}
