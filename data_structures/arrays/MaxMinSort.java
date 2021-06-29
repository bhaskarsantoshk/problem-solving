package data_structures.arrays;

public class MaxMinSort {
    public static void rearrange(int[] a){
        int max_index = a.length-1, min_index = 0;
        int max = a[max_index]+1;

        for ( int i=0; i<a.length; i++){
            if ( i % 2 == 0) {
                a[i] += (a[max_index] % max) * max;
                max_index--;
            } else {
                a[i] += (a[min_index] % max) * max;
                min_index++;
            }
        }
        for ( int i=0; i<a.length; i++){
            a[i] = a[i]/max;
        }
    }
}
