package Recursion;

import static Recursion.DataFormatter.swap;

public class Sort {
    public static void sortArray(int[] a, int n) {
        if ( n == 1){
            return;
        }
        for ( int i=0; i<n-1; i++){
            if ( a[i] > a[i+1]){
                swap(a,i, i+1);
            }
        }
        sortArray(a, n-1);
    }
}
