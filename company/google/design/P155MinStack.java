package company.google.design;

public class P155MinStack {
    Node head;
    class Node {
        int val, min;
        Node next;

        Node (int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public P155MinStack(){

    }

    public void push(int val){
        if ( head == null ) head = new Node(val, val, null);
        else head = new Node(val, Math.min(val, head.min), head );
    }

    public void pop(){
        if ( head == null ) throw new IllegalStateException("Stack is Empty");
        head = head.next;
    }

    public int top(){
        if ( head == null ) throw new IllegalStateException("Stack is Empty");
        return head.val;
    }

    public int getMin(){
        if ( head == null ) throw new IllegalStateException("Stack is Empty");
        return head.min;
    }
}
