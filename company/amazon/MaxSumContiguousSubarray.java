public class MaxSumContiguousSubarray {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        if ( A == null || A.size() == 0) return 0;
        int local_sum = A.get(0);
        int global_sum = A.get(0);
        for ( int i=1; i<A.size(); i++){
            local_sum = Math.max ( local_sum+A.get(i), A.get(i));
            global_sum = Math.max(local_sum, global_sum);
        }
        return global_sum;
    }
}
