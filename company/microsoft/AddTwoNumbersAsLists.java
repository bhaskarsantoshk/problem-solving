package company.microsoft;

public class AddTwoNumbersAsLists {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int carry=0;

        while(a!=null || b!=null || carry!=0 ){
            if(a!=null){
                carry+=a.val;
                a=a.next;
            }
            if(b!=null){
                carry+=b.val;
                b=b.next;
            }
            p.next= new ListNode(0);
            p.next.val = carry%10;
            carry=carry/10;
            p=p.next;
        }

        return dummy.next;
    }
}
