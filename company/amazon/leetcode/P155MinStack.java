package company.amazon.leetcode;

public class P155MinStack {
    private Node head;

    public P155MinStack() {

    }

    public void push(int val) {
        if ( head == null ) {
            head = new Node(val, val, null);
        }
        else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        if ( head == null ) return;
        head = head.next;
    }

    public int top() {
        if ( head == null ) return -1;
        return head.val;
    }

    public int getMin() {
        if ( head == null ) return Integer.MAX_VALUE;
        return head.min;
    }

    class Node{
        int val, min;
        Node next;
        public  Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

}
