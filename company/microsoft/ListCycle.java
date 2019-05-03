package company.microsoft;

public class ListCycle {
    public ListNode detectCycle(ListNode a) {
        ListNode slow = a;
        ListNode fast = a;
        boolean hasCycle = false;
        while(fast.next!=null && fast.next.next!=null){
            if(fast.equals(slow)){
                hasCycle= true;
                break;
            }
            slow= slow.next;
            fast= fast.next.next;
        }

        if(!hasCycle){
            return null;
        }

        fast = a;

        while(!slow.equals(fast)){
            slow=slow.next;
            fast=fast.next;
        }

        return fast;
    }
}
