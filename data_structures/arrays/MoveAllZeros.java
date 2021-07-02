package data_structures.arrays;

public class MoveAllZeros {
    public static void moveAllZerosToLeft(int[] a){
        if ( a== null || a.length == 0){
            return;
        }
        int writeIndex = a.length-1;
        int readIndex = a.length-1;
        while ( readIndex >=0){
            if ( a[readIndex] != 0){
                a[writeIndex--] = a[readIndex];
            }
            readIndex--;
        }
        while (writeIndex>=0){
            a[writeIndex--] = 0;
        }
    }
}
