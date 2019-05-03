package company.microsoft;

public class ReorderList {
    public ListNode reorderList(ListNode head) {
        if(head == null || head.next== null){
            return head;
        }

        //Find the middle of the Linked List

        ListNode p1 = head;
        ListNode p2 = head;

        while(p2.next!= null && p2.next.next!=null){
            p1=p1.next;
            p2= p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4

        ListNode middle = p1;
        ListNode current = p1.next;

        while(current.next != null){
            ListNode next = current.next;
            current.next = next.next;
            next.next = middle.next;
            middle.next= next;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1 = head;
        p2= middle.next;

        while(p1 != middle){
            middle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1= p2.next;
            p2= middle.next;
        }
        return head;
    }
}

