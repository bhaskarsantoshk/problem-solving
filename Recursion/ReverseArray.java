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
        reverse(a, 0, 6);
        print(a);
    }

    public static void reverse(int[] a){
        reverse(a, 0, a.length-1);
    }

    private static void reverse(int []a, int start, int end){
        if ( start> end) return;
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
        reverse(a, start+1, end-1);
    }
}
