package data_structures.arrays;

public class RearrangeSortedArrayInMaxMinForm {
    public static void rearrangeSortedArrayInMaxMinForm(int[] arr) {
       int minIndex = 0;
       int maxIndex = arr.length-1;
       int maxElement = arr[maxIndex] + 1;
       for ( int i=0; i<arr.length; i++){
           if ( i % 2 == 0){
               arr[i] += (arr[maxIndex]%maxElement) * maxElement;
               maxIndex--;
           } else {
               arr[i] += (arr[maxIndex]%maxElement)* maxElement;
               minIndex++;
           }
       }
       for ( int i=0; i<arr.length; i++){
           arr[i] /= maxElement;
       }
    }
}
