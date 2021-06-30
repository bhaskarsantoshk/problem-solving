package data_structures.arrays;

public class MaxSumSubArray {
    public static int maxSumSubArray(int [] a){
        int local_max = 0;
        int global_max = 0;

        for ( int i=0; i<a.length; i++){
            local_max= Math.max(local_max+a[i], a[i]);
            global_max = Math.max(local_max, global_max);
        }
        return global_max;
    }
}
