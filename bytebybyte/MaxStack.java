package bytebybyte;

public class MaxStack {

    private  class Node{
        private int val;
        private Node next;
        private Node oldMax;
    }

    private Node stack;
    private Node max;

    public MaxStack() {}

    public void push(int x){
        Node n = new Node();
        n.val = x;
        if (stack != null) {
            n.next = stack;
        }
        stack = n;

        if ( max == null || n.val > max.val){
            n.oldMax = max;
            max = n;
        }
    }

    public int pop(){
        if ( stack == null ) {
            throw new NullPointerException();
        }
        Node n = stack;
        stack = n.next;
        if ( n.oldMax != null ){
            max = n.oldMax;
        }
        return  n.val;
    }

    public int max(){
        if (max == null) {
            throw new NullPointerException();
        }
        return max.val;
    }

}

// push, pop, max should be in O(1)
// Stack would mean LIFO Data Structure- verify with interviewer
// Stack - Linked List would help easily to simulate LIFO - add to front
// we store extra variable that is max so far at each node - but at a worst case - we are storing O(N) space - which is not recommended
// Best approach is to have pointer to old max




