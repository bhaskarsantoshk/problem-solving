package dynamic_programming.recursion;

public class HeadAndTailRecursion {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        headRecursion(head);
        System.out.println();
        tailRecursion(head);
    }

    private static void headRecursion(ListNode head) {
        if(head!=null){
            headRecursion(head.next);
            System.out.print(head.data+" ");
        }
    }

    public static void tailRecursion(ListNode head){
        if(head!=null) {
            System.out.print(head.data + " ");
            tailRecursion(head.next);
        }

    }

    static class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
        }
    }
}
