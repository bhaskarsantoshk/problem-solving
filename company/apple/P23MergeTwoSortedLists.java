package company.apple;

public class P23MergeTwoSortedLists {
    public ListNode mergeTwoListsRec(ListNode list1, ListNode list2) {
        if ( list1 == null ) return list2;
        if ( list2 == null) return list1;

        if ( list1.val < list2.val){
            list1.next = mergeTwoListsRec(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRec(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if ( list1 == null || list2 == null) return list1 != null? list1: list2;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while ( list1 != null && list2 != null){
            if ( list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = (list1 != null) ? list1: list2;
        return dummy.next;
    }
}
