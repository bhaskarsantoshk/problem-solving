package data_structures.arrays;

public class SecondMax {
    public static int secondMax(int[] a){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for ( int num: a){
            if ( num > max ){
                secondMax = max;
                max = num;
            }
            else if (num > secondMax){
                secondMax = num;
            }
        }
        return secondMax;
    }
}
