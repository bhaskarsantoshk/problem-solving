package company.apple;

public class P53MinStack {
    /*
    Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
     */

    class Node{
        int val, min;
        Node next;
        Node(int val, int min, Node next){
            this.min = min;
            this.val = val;
            this.next = next;
        }
    }

    P53MinStack(){

    }

    Node head;

    public void push(int val){
        if ( head == null) head = new Node(val, val, null);
        else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop(){
        if ( head == null) throw new IllegalStateException("Stack is empty");
        head = head.next;
    }

    public int top(){
        if ( head == null) throw new IllegalStateException("Stack is empty");
        return head.val;
    }
    public int getMin(){
        if ( head == null) throw new IllegalStateException("Stack is empty");
        return head.min;
    }
}
