package company.microsoft.linkedlists;

import company.microsoft.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {

    // Naive solution using Hashing

    public ListNode getIntersectionNodeUsingHashing(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur1 = headA, cur2 = headB;
        while ( cur1 != null ){
            set.add(cur1);
            cur1 = cur1.next;
        }
        while ( cur2 != null ){
            if ( set.contains(cur2)) return cur2;
            cur2 = cur2.next;
        }
        return null;
    }

    // Get lengths of both lists
    // Move the longer one to difference between the lengths
    // then they both are at same level
    // Now compare each node
    // T = O ( N1 + 2 N2 )
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur = headA;
        int lenA = 0;
        while ( cur != null ){
            lenA++;
            cur = cur.next;
        }
        int lenB = 0;
        cur = headB;
        while ( cur != null ){
            lenB++;
            cur = cur.next;
        }

        if ( lenA < lenB){
           return collisonPoint( headA, headB, lenB-lenA);
        } else return collisonPoint( headB, headA, lenA-lenB);
    }

    private ListNode collisonPoint(ListNode node1, ListNode node2, int d) {
        while ( d-- > 0) node2 = node2.next;
        while ( node1 != null && node2 != null){
            if ( node1 == node2) return node1;
            node1 = node1.next;
            node2 = node2.next;
        }
        return null;
    }

    // Optimized
    // T = O ( N1 + N2 )
    // diff between l1 and l2 = d
    // by the time l1 reaches null, l2 is d steps away from null
    // when l2 reaches null, l1 is 2 steps ahead in other LL
    // now they both start at same level, so we can compare
    public ListNode getIntersectionNodeOptimized(ListNode headA, ListNode headB) {
        if ( headA == null || headB == null ) return null;
        ListNode l1 = headA;
        ListNode l2 = headB;
        while ( l1 != l2 ){
            l1 = l1.next;
            l2 = l2.next;
            if ( l1 == l2 ) return l1;
            if ( l1 == null ) l1 = headB;
            if ( l2 == null ) l2 = headA;
        }
        return l1;
    }

}
