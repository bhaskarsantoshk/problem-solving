package data_structures.arrays;

public class ReArrangePositiveNegativeValues {
    public static void reArrangePositiveNegativeValues(int[] arr) {
        int index = 0;
        for ( int i=0; i<arr.length; i++){
            if ( arr[i] < 0){
                if ( i!= index){
                    int temp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = temp;
                }
                index++;
            }
        }
    }
}
