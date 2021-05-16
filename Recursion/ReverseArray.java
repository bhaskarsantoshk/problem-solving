package Recursion;

import static Recursion.DataFormatter.print;
import static Recursion.DataFormatter.swap;

public class ReverseArray {
    public static void invert(int a[], int index){
        if ( index < a.length/2){
            swap(a, index, a.length-1-index);
            invert(a, index+1);
        }
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7};
        invert(a,0);
        print(a);
    }
}
