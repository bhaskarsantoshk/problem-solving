package takeUForward.linkedlists;

public class P22OddAndEvenPositionedLinkedListNodes {
    public static Node oddEvenLinkedList(Node head) {
        if (head == null || head.next == null) return head;
        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
