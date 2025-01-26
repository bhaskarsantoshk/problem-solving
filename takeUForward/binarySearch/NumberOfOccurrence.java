package takeUForward.binarySearch;

public class NumberOfOccurrence {
    public static int count(int arr[], int n, int x) {
        int firstOccurrence = getFirstOccurrence( arr, n, x);
        if ( firstOccurrence == -1) return 0;
        int lastOccurrence = getLastOccurrence( arr, n, x);
        return lastOccurrence - firstOccurrence+1;
    }

    private static int getFirstOccurrence( int [] arr, int n, int x){
        int low = 0, high = n-1;
        int first = -1;
        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( arr[mid] == x){
                first = mid;
                high = mid-1;
            } else if ( arr[mid] < x){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return first;
    }

    private static int getLastOccurrence( int [] arr, int n, int x){
        int low = 0, high = n-1;
        int last = -1;
        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( arr[mid] == x){
                last = mid;
                low = mid+1;
            } else if ( arr[mid] < x){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return last;
    }
}
