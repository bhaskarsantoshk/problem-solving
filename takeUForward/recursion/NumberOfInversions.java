package takeUForward.recursion;

public class NumberOfInversions {
    static int count ;
    public static int numberOfInversions(int []a, int n) {
        count = 0;
        mergeSort(a, 0, n-1);
        return count;
    }

    private  static void mergeSort(int a[], int low, int high){
        if ( low < high ){
            int mid = low + (high-low)/2;
            mergeSort( a, low, mid);
            mergeSort( a, mid+1, high);
            merge( a, low, mid, high);
        }
    }

    private static void merge(int[] a, int low, int mid, int high){
        int left = low;
        int right = mid+1;
        int [] mergeArray = new int[high-low+1];
        int mergeIndex = 0;
        while ( left <= mid && right <= high ){
            if ( a[left] <= a[right]){
                mergeArray[mergeIndex] = a[left];
                left++;
            } else {
                mergeArray[mergeIndex] = a[right];
                count += ( mid -left+1);
                right++;
            }
            mergeIndex++;
        }

        while ( left <= mid){
            mergeArray[mergeIndex++] = a[left++];
        }

        while ( right <= high ){
            mergeArray[mergeIndex++] = a[right++];
        }

        for ( int i=0; i<mergeArray.length; i++){
            a[low+i]= mergeArray[i];
        }
    }
}
