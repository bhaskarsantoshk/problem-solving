package company.google.version2;

import java.util.ArrayList;
import java.util.List;

public class P2AddTwoNumbers {
    public ListNode addTwoNumbersNaive(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        ListNode cur = l1;
        while ( cur!= null){
            list1.add(cur.val);
            cur = cur.next;
        }

        List<Integer> list2 = new ArrayList<>();
         cur = l2;
        while ( cur!= null){
            list2.add(cur.val);
            cur = cur.next;
        }

        List<Integer> res = new ArrayList<>();
        int carry = 0;
        int i =0;
        while ( i < list1.size() || i < list2.size()){
            int sum = 0;
            sum += ( i < list1.size()) ? list1.get(i): 0;
            sum += ( i < list2.size()) ? list2.get(i): 0;
            sum += carry;
            res.add(sum%10);
            carry = sum/10;
            i++;
        }

        if (carry > 0) {
            res.add(carry);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int num : res) {
            tail.next = new ListNode(num);
            tail = tail.next;
        }

        return dummy.next;

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while ( l1 != null || l2 != null || carry != 0){
            int sum = carry;
            if ( l1 != null) { sum += l1.val; l1 = l1.next;}
            if ( l2 != null) { sum += l2.val; l2 = l2.next;}
            cur.next = new ListNode(sum%10);
            carry = sum/10;
            cur = cur.next;
        }
        return dummy.next;
    }
}
