package company.amazon.interviewbit;

import java.util.List;

public class FindDuplicateInArray {
    public int repeatedNumber(final List<Integer> a) {
        if ( a == null || a.size() == 0 || a.size() == 1) return -1;
        int slow = 0;
        int fast = 0;
        do {
            slow = a.get(slow);
            fast = a.get(a.get(fast));
        } while ( slow != fast);
        slow = 0;
        while ( slow != fast ){
            slow = a.get(slow);
            fast = a.get(fast);
        }
        return slow;
    }
}
