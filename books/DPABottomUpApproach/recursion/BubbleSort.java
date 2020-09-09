package books.DPABottomUpApproach.recursion;

import java.util.Arrays;
import java.util.Collections;

public class BubbleSort {

    public static void bubbleSort (int [] a, int n){
        for ( int i=0; i<n; i++){
            for ( int j=0; j<n-i-1; j++){
                if (a[j] > a[j+1]){
                    Collections.swap(Arrays.asList(a), j, j+1);

                }
            }
        }
    }

    public static void bubbleSortRec (int[] a, int n){
        for ( int j=0; j<n-1; j++){
            if (a[j] > a[j+1]){
                Collections.swap(Arrays.asList(a), j, j+1);
            }
        }
        bubbleSortRec(a, n-1);
    }
}
