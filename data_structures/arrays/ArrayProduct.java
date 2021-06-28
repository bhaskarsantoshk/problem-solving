package data_structures.arrays;

public class ArrayProduct {
    public static int[] arrayProduct (int[] a){
        int temp = 1;
        int res[] = new int[a.length];
        for ( int i=0; i<a.length; i++){
            res[i] = temp;
            temp *= a[i];
        }
        temp = 1;
        for ( int i=a.length-1; i>=0; i--){
            res[i] *= temp;
            temp *= a[i];
        }
        return res;
    }
}
