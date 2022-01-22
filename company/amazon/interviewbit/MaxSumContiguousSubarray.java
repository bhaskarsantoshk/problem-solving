package company.amazon.interviewbit;

public class MaxSumContiguousSubarray {
    public int maxSubArray(final int[] a) {
        if ( a == null || a.length == 0) return -1;
        int local_max = a[0], global_max = a[0];
        for ( int i=1; i<a.length; i++){
            local_max = Math.max ( local_max+a[i], a[i]);
            global_max = Math.max ( local_max, global_max);
        }
        return global_max;
    }
}
