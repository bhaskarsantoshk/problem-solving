package LeetCode.explore.arrays;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if ( arr == null || arr.length == 0 || arr.length == 1){
            return false;
        }
       boolean inc = false;
       boolean dec = false;
        for ( int i=0; i<arr.length-1; i++){
            if ( dec == false && arr[i] < arr[i+1] ){
                inc = true;
            }
            else if ( inc == true && arr[i] > arr[i+1]) {
                dec = true;
            }
            else {
                return false;
            }
        }
        return (inc == true && dec == true) ? true: false; 
    }
}