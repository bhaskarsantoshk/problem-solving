package striver_sde_sheet.linkedlists;

import company.microsoft.ListNode;

public class P21MergeTwoSortedLists {

    // if we have to make an entirely new Linked list
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while ( list1 != null && list2 != null ){
            if ( list1.val < list2.val){
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;
        }
        while ( list1 != null ){
            cur.next = new ListNode(list1.val);
            cur = cur.next;
            list1 = list1.next;
        }
        while ( list2 != null ){
            cur.next = list2;
            cur = cur.next;
            list2 = list2.next;
        }
        return dummy.next;
    }


    public ListNode mergeTwoListsInPlace(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while ( list1 != null && list2 != null ){
            if ( list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if ( list1 != null ) cur.next = list1;
        if ( list2 != null ) cur.next = list2;
        return dummyNode.next;
    }


    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if ( list1 == null ) return list2;
        if ( list2 == null ) return list1;

        if (list1.val <= list2.val){
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }
}
