package LeetCode;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;

public class P146LRUCache {
    // Brute Force
    /*
     1. Array of N nodes - equal to the size of the cache
     GET:
     2. get ( int key ) - simply iterate over the array and return if found else -1
     T = O(N)
     SET:
     3. set (int key, int value) - if array is full, we will delete one node from Array
     and find the array with least timestamp value and delete it. insert our new entry in  place
     of LRU node.
     4. If the array is not full , we will insert our entry at the last current index of our array
     T = O (N)

    */


    class Node{
        int key;
        int value;
        long timeStamp;

        public Node (int key, int value ){
            this.key = key;
            this.value = value;
            this.timeStamp = new Date().getTime();
        }
    }



    // Optimized

    private Hashtable<Integer, DListNode> cache = new Hashtable<Integer, DListNode>();
    private int capacity;
    private int count;
    private DListNode head, tail;

    public P146LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new DListNode();
        tail = new DListNode();
        head.prev = null;
        tail.next = null;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DListNode NODE = cache.get ( key );
        if ( NODE == null ){
            return -1;
        }
        this.moveToHead(NODE);
        return NODE.value;
    }

    public void put(int key, int value) {
        DListNode NODE = cache.get(key);
        if ( NODE == null ){
            DListNode newNode = new DListNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            ++count;
            if ( count > capacity ){
                DListNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        }
        else{
            NODE.value = value;
            this.moveToHead(NODE);
        }
    }

    public DListNode popTail(){
        DListNode popped = tail.prev;
        this.removeNode(popped);
        return popped;
    }

    class DListNode {
        int key;
        int value;
        DListNode prev;
        DListNode next;
    }

    private void moveToHead(DListNode NODE ){
        this.removeNode(NODE);
        this.addNode(NODE);
    }

    private void removeNode(DListNode NODE){
        DListNode NEXT = NODE.next;
        DListNode PREV = NODE.prev;
        PREV.next = NEXT;
        NEXT.prev = PREV;
    }

    private void addNode( DListNode NODE ){
        NODE.prev = head;
        NODE.next = head.next;
        head.next.prev = NODE;
        head.next = NODE;

    }

}
