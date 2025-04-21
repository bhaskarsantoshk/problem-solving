package takeUForward.stacks;

import takeUForward.linkedlists.Node;

public class P4QueueUsingLinkedList {
    Node start, end;
    int size = 0;

    void push(int x){
        Node temp = new Node(x);
        if ( start == null){
            start =end = temp;
        } else {
            end.next = temp;
            end = temp;
        }
        size++;
    }

    int pop(){
        if ( start == null) return -1;
        Node res = start;
        size--;
        start = start.next;
        return res.data;
    }

    int top(){
        if ( start == null) return -1;
        return start.data;
    }
}
