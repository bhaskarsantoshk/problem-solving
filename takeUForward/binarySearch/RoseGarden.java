package takeUForward.binarySearch;

public class RoseGarden {
    public static int roseGarden(int[] arr, int r, int b) {
        int low = Integer.MAX_VALUE, high = 0;
        for ( int num: arr){
            low = Math.min( low, num);
            high = Math.max( high, num);
        }

        int ans = -1;
        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( isPossible(arr, r, b, mid)){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    private static boolean isPossible ( int[] arr, int r, int b, int day){
        int count = 0, noBoquets = 0;
        for ( int i=0; i< arr.length; i++){
            if ( arr[i] <= day ){
                count++;
            } else {
                noBoquets += count / r;
                count = 0;
            }
        }
        noBoquets += count/r;
        return noBoquets >= b;
    }
}
