package takeUForward.linkedlists;

public class P1CountNodesOfLnkedList {
    class Node {
        public int data;
        public Node next;

        Node()
        {
            this.data = 0;
            this.next = null;
        }

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }


    public static int length(Node head){
        Node cur = head;
        int count = 0;
        while ( cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
}
