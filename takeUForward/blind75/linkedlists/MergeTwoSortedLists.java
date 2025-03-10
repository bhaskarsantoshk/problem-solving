package takeUForward.blind75.linkedlists;

import company.microsoft.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if ( list1 == null) return list2;
        if ( list2 == null ) return list1;
        if ( list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur1 = list1, cur2 = list2;
        ListNode cur = dummy;
        while ( cur1 != null && cur2 != null){
            if ( cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if ( cur1 != null){
            cur.next = cur1;
        }
        if ( cur2 != null){
            cur.next = cur2;
        }

        return dummy.next;
    }

}
