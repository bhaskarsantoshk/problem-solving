package company.amazon.leetcode;

public class P1492TheKthFactorOfN {
    public int kthFactor(int n, int k) {
        int d = 1;
        for ( ; d <= n/d ; d++){
            if ( n % d == 0 && --k == 0){
             return d;
            }
        }
        for ( d = d-1; d>=1; d--){
            if ( d == n/d ) continue;
            if ( n % d == 0 && --k == 0){
                return n/d;
            }
        }
        return -1;
    }
}

/**
 * https://leetcode.com/problems/the-kth-factor-of-n/discuss/959372/7-line-Java-O(sqrt-n)-time-O(1)-space-not-a-typical-explanation
 * https://leetcode.com/problems/the-kth-factor-of-n/discuss/708099/C%2B%2BJava-Straightforward-%2B-Sqrt(n)
 */
