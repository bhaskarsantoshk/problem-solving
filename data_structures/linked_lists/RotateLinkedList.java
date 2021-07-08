package data_structures.linked_lists;

public class RotateLinkedList {
    // 1 -> 2 -> 3 -> 4 -> 5
    // rotate by 2 (from right): 4 -> 5 -> 1 -> 2 -> 3
    // 1 -> 2 -> 3 -> 4 -> 5
    // rotate by 7 (from right ): 4 -> 5 -> 1 -> 2 -> 3
    // 1 -> 2 -> 3 -> 4 -> 5
    // rotate by -2 (from left side): 3 -> 4 -> 5 -> 1 -> 2

    public static Node rotateList (Node head, int n){
        if ( head == null || n == 0){
            return head;
        }
        int length = getLengthOfList(head);
        n = getadjustedNumberOfRotations(n, length);
        if ( n == 0){
            return head;
        }
        int rotatedPoint = length - n -1;
        Node temp = head;
        while ( rotatedPoint > 0){
            temp = temp.next;
            rotatedPoint--;
        }
        Node newHead = temp.next;
        temp.next = null;
        temp = newHead;
        while ( temp.next != null ){
            temp = temp.next;
        }
        temp.next = head;
        return newHead;

    }

    private static int getadjustedNumberOfRotations(int n, int length) {
        n = n % length;
        if ( n < 0){
            n = n+ length;
        }
        return n;
    }

    private static int getLengthOfList(Node head) {
        if ( head == null ) return 0;
        Node cur = head;
        int len = 0;
        while ( cur != null ){
            len++;
            cur = cur.next;
        }
        return len;
    }
}
