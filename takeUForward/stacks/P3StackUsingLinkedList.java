package takeUForward.stacks;

import takeUForward.linkedlists.Node;
public class P3StackUsingLinkedList {
    Node top;
    int size;

    void push(int x){
        Node temp = new Node(x);
        temp.next = top;
        top = top.next;
        size++;
    }

    int top(){
        if ( top == null) return -1;
        return top.data;
    }

    int pop(){
        if ( top == null) return -1;
        Node temp = top;
        top = top.next;
        size--;
        return temp.data;
    }

    int size() {
        return size;
    }
}
