package data_structures.arrays;

public class RotateArray {
    public static void rotateBy1(int[] a){
        int last = a[a.length-1];
        for ( int i=a.length-1; i>0; i--){
            a[i] = a[i-1];
        }
        a[0] = last;
    }
}
