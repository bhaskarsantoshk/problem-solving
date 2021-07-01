package data_structures.arrays;

public class SearchRotatedArray {
    public static int binarySearchRotated(int[] a,int key) {
        int start = 0;
        int end = a.length-1;

        while ( start <= end ){
            int mid = start + (end-start)/2;
            if ( a[mid] == key ){
                return mid;
            }
            // To see which side of mid is sorted
            // Right
            if ( a[mid] < a[end]){
                // To check if key is in between
                if ( a[mid] < key && a[end] >= key){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            else if (a[mid] > a[start]){
                if (a[mid] > key && a[start] <= key){
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }
            }
            else {
                return -1;
            }

        }
        return -1;
    }
}
