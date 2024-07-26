package company;

import company.microsoft.ListNode;

import java.util.ArrayList;
import java.util.List;

public class P328OddEvenLinkedList {
    public ListNode oddEvenListBruteForce(ListNode head) {
        if ( head == null ) return null;
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while ( node != null ){
            list.add(node.val);
            if ( node.next != null ){
                node = node.next.next;
            } else {
                break;
            }
        }

        node = head.next;
        while ( node != null ){
            list.add(node.val);
            if ( node.next != null ){
                node = node.next.next;
            } else {
                break;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for ( int num: list){
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode oddEvenList(ListNode head) {
        if ( head == null || head.next == null ) return head;
        ListNode odd = head, even = head.next, evenHead = head.next;

        // if even doesn't reach end, odd will not reach as even is one pointer ahead
        // so it's better to track even
        while (even != null && even.next != null ){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }


}
