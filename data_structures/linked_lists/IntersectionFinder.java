package data_structures.linked_lists;

public class IntersectionFinder {
    public static Node getIntersectionPoint(Node a, Node b ){
        if ( a == null || b == null) return null;
        Node headA = a;
        Node headB = b;
        while ( !a.equals(b)){
            headA = (headA != null ) ? headA.next: b;
            headB = (headB != null ) ? headB.next: a;
        }
        return headA;
    }
}
