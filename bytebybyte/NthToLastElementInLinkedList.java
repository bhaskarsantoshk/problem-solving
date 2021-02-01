package bytebybyte;

public class NthToLastElementInLinkedList {

    public Node nthToLast(Node head, int n){
        Node cur = head;
        Node follower = head;
        // Assumption n is greater than length, but it's safe to handle the edge case
        for ( int i=0; i<n; i++){
            if ( cur == null ){
                return null;
            }
            cur = cur.next;
        }
        while ( cur.next != null){
            cur = cur.next;
            follower = follower.next;
        }
        return follower;
    }


    private class Node{
        private int val;
        private Node next;
    }

}

// short notes: (len-n)th will be the result
// One approach : two passes - one for finding length and 2nd pass to go to (len-n)th, N+N - O(N)
// Best approach: current and follower pointer - both at head
// first we move current node to n positions , and then we move follower and current in sync
// when current reaches the end, follower will be exactly at the desired position ( n behind current )
