package data_structures.arrays;

public class RightRotateTheArrayByOneIndex {
    public static void rightRotateTheArrayByOneIndex(int[] arr) {
        int temp = arr[arr.length-1];
        for ( int i=arr.length-1; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }
}
