package data_structures.arrays;

public class ArrayMin {
    public static int getMin(int a[]){
        int min = Integer.MAX_VALUE;
        for ( int num: a){
            min = Math.min(min, num);
        }
        return min;
    }
}
