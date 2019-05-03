package company.microsoft;

public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next= head;
        ListNode p= temp;

       while(p.next!= null && p.next.next!=null){
           if(p.next.val==p.next.next.val){
               int dup= p.next.val;

               while(p.next!=null && p.next.val== dup){
                   p.next=p.next.next;
               }
           }
           else{
               p=p.next;
           }
       }

       return temp.next;

    }
}
