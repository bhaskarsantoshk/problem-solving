package company.google;

public class P852PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        for ( int i=0; i<arr.length; i++){
            if ( (i== 0 || arr[i] > arr[i-1]) && ( i==arr.length-1 || arr[i] > arr[i+1])) return arr[i];
        }
        return 0;
    }

    public int peakIndexInMountainArrayBinarySearch(int[] arr) {
        if ( arr == null || arr.length == 0) return -1;
        if ( arr.length == 1) return 0;
        if ( arr[0] > arr[1]) return 0;
        int n = arr.length;
        if ( arr[n-1] > arr[n-2]) return n-1;

        int start = 1, end = arr.length-2;

        while ( start <= end ){
            int mid = start + (end-start)/2;
            if ( arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
                return mid;
            } else if ( arr[mid] > arr[mid-1]){
                start = mid+1;
            } else end = mid-1;
        }
        return -1;
    }
}
