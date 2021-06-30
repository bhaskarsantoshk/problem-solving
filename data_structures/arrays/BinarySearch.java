package data_structures.arrays;

public class BinarySearch {
    public static int binarySearch(int a[], int key){
        return binarySearch(a,0, a.length-1, key);
    }

    private static int binarySearch(int[] a, int start, int end, int key) {
        if ( start < end ) return -1;
        int mid = start + (end- start)/2;

        if (a[mid] == key){
            return mid;
        }
        if ( a[mid] > key){
            return binarySearch(a, start, mid-1, key);
        }
        return binarySearch(a, mid+1, end, key);
    }


    public static int binarySearchIterative(int[] a, int key){
        if ( a == null || a.length == 0){
            return -1;
        }
        int start = 0;
        int end = a.length-1;

        while ( start <= end){
            int mid =  start + (end- start)/2;

            if ( a[mid] == key){
                return key;
            }
            if ( a[mid] > key ){
                end = mid-1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
