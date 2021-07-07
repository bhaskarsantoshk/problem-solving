package data_structures.linked_lists;

public class DoublyListNode {
    int data;
    DoublyListNode prev;
    DoublyListNode next;

    public DoublyListNode(int data){
        this.data = data;
    }

    public static void printList(DoublyListNode head){
        DoublyListNode cur = head;
        while ( cur!= null ){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
