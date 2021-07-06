package data_structures.linked_lists;

public class MidPointOfLinkedList {
    public static Node getMiddleNode ( Node head ){
        Node slow = head;
        Node fast = head;
        while ( slow != null && fast != null && fast.next != null ){
            fast = fast.next.next;
            if ( fast != null ){
                slow = slow.next;
            }
        }
        return slow;
    }

    public static void main(String[] args){
        Node head = new Node(0);
        Node node = head;
        for ( int i=0; i<6; i++){
            node.next = new Node(i+1);
            node = node.next;
        }

       System.out.println(getMiddleNode(head).data);
    }
}
