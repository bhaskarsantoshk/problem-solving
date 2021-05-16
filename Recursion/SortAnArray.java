package Recursion;

import static Recursion.DataFormatter.print;
import static Recursion.DataFormatter.swap;

public class SortAnArray {
    public static void sort(int[] a, int length){
        if (length == 0){
            return;
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for ( int i=0; i<length; i++){
            if ( max < a[i]){
                max = a[i];
                index = i;
            }
        }
        swap(a, index, length-1);
        sort(a, length-1);
    }


    public static void sortArray(int[] array, int n) {
        if (n==1) {
            return;
        }
        for (int i = 0; i < n-1; i++) {
            if (array[i] > array[i+1]) {
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
        sortArray(array, n-1);
    }

    public static void main(String[] args){
        int[] a = {2,3,7,4,1,5,6};
        sort(a, 7);
        print(a);
    }
}
