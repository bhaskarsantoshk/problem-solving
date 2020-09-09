package books.DPABottomUpApproach.recursion;

public class HeadAndTailRecursion {
    public static void headRecursion( Node head){
        if ( head != null ){
            headRecursion(head.next);
            System.out.println(head.data);
        }
    }

    public static void tailRecursion (Node head){
        if (head != null ){
            System.out.println(head.data);
            tailRecursion(head.next);
        }
    }

    class Node{
        int data;
        Node next;
    }
}
