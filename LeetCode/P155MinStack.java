package LeetCode;

import java.util.NoSuchElementException;

public class P155MinStack {
    private Node top;
    public P155MinStack() {

    }

    public void push(int x) {
        Node newTop = new Node(x);
        newTop.next = top;
        if(top != null){
            newTop.minSoFar = Math.min(newTop.val, top.minSoFar);
        }
        top = newTop;
    }

    public void pop() {
        if(top == null){
            throw new NoSuchElementException();
        }
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.minSoFar;
    }

    class Node{
        int val;
        int minSoFar;
        Node next;

        public Node(int x){
            this.val = x;
            this.minSoFar = x;
        }
    }
}
