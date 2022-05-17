package express_prep.amzn.top_voted;

public class MinStack {
    private Node top = null;
    public MinStack() {

    }

    public void push(int val) {
        Node node = new Node(val);
        if ( top == null ){
            top = node;
        } else {
            node.min = Math.min(top.min, val);
            node.next = top;
        }
        top = node;
    }

    public void pop() {
        if ( top == null ) return;
        top = top.next;
    }

    public int top() {
        if ( top == null ) return -1;
        return top.val;
    }

    public int getMin() {
        if ( top == null ) return -1;
        return top.min;
    }

    class Node {
        int val;
        int min;
        Node next;
        Node (int val){
            this.val = val;
            this.min = val;
        }
    }
}
