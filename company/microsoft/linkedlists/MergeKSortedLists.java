package company.microsoft.linkedlists;

import company.microsoft.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>( (a,b) -> a.val-b.val);
        for ( ListNode node : lists){
            if ( node != null)  pq.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while ( !pq.isEmpty()){
            ListNode node = pq.poll();
            cur.next = new ListNode(node.val);
            if ( node.next != null ) pq.offer(node.next);
            cur = cur.next;
        }
        return dummy.next;
    }
}
