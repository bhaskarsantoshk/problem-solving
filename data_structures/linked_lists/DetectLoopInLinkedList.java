package data_structures.linked_lists;

public class DetectLoopInLinkedList {
    public static boolean checkIfCycleExists ( Node head ){
        Node slow = head;
        Node fast = head;
        while ( slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast) return true;
        }
        return false;
    }
}
