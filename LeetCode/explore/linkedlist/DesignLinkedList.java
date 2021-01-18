package LeetCode.explore.linkedlist;

class MyLinkedList {

    // Definition of a node
    public class Node{
        int val;
        Node next;
        Node(int x) { val = x; }
    }

    // Sentinel node, initial node as head
    Node head;
    int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new Node(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0 || index>=size) return -1;

        // Count from the sentinel node
        Node curr = head;
        // Because we have the initial node at the index0, so we have to find the index+1
        for(int i =0; i < index+1; i++){
            curr = curr.next;
        }
        return curr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        size++;

        // Find the previous node of the node we want to add
        Node pre = head;
        for(int i = 0; i < index; i++) pre = pre.next;

        // Node we want to add
        Node add = new Node(val);

        // Insert after the previous node
        add.next = pre.next;
        pre.next = add;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        // Valid check
        if(index<0 || index >= size) return;

        // Find the previous node of the node we want to add
        Node pre = head;
        for(int i = 0; i < index; i++) pre = pre.next;

        // Delete pre.next
        pre.next = pre.next.next;

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */