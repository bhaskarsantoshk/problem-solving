package data_structures.arrays;

public class ReArrange {
    public static  void reArrange(int[] a){
        int index = 0;
        for ( int i=0; i<a.length; i++){
            if ( a[i] < 0){
                if ( index != i){
                    int temp = a[i];
                    a[i] = a[index];
                    a[index] = temp;
                }
                index++;
            }
        }
    }
}
