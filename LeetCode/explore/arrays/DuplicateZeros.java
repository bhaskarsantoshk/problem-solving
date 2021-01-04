package LeetCode.explore.arrays;

public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int count = 0;
        for ( int num: arr){
            if ( num == 0) count++;
        }
        int []temp = new int[arr.length+count];
        int index = 0;
        for ( int i=0; i<arr.length; i++){
            if ( arr[i] != 0 ){
                temp[index++] = arr[i];
            }
            if (arr[i] == 0 ) {
                temp[index++] = 0;
                temp[index++] = 0;
            }
        }
        for ( int i=0; i<arr.length; i++){
            arr[i] = temp[i];
        }
    }

}