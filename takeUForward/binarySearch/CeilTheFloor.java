package takeUForward.binarySearch;
// https://www.naukri.com/code360/problems/ceiling-in-a-sorted-array_1825401?leftPanelTabValue=PROBLEM

public class CeilTheFloor {
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        int [] ans = new int[2];
        ans[0] = getFloor(a,x,n);
        ans[1] = getCeil(a, x, n);

        return ans;
    }

    private static int getCeil(int[] arr, int X, int N){
        int low = 0, high = N-1, ans = -1;
        while ( low <= high){
            int mid = low + (high-low)/2;
            if ( arr[mid] >= X){
                ans = arr[mid];
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    private static int getFloor(int[] arr, int X, int N) {
        int low = 0, high = N-1, ans = -1;
        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( arr[mid] <= X){
                ans = arr[mid];
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
}
