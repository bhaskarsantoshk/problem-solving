package company.amazon.leetcode;

import java.util.PriorityQueue;

public class P23MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if ( lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (l1,l2)->l1.val-l2.val);
        for ( int i=0; i<lists.length; i++){
            if (lists[i] != null){
                pq.offer(lists[i]);
            }
        }
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while ( !pq.isEmpty() ){
             cur.next = pq.poll();
             cur = cur.next;
             if ( cur.next != null ){
                 pq.offer(cur.next);
             }
        }
        return res.next;
    }
}
