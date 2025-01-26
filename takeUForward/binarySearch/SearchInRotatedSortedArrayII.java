package takeUForward.binarySearch;

// https://www.naukri.com/code360/problems/search-in-a-rotated-sorted-array-ii_7449547?leftPanelTabValue=PROBLEM

public class SearchInRotatedSortedArrayII {
    public static boolean searchInARotatedSortedArrayII(int []a, int key) {
        int low = 0, high = a.length-1;
        while ( low <= high ){
            int mid = low + (high-low)/2;
            if (a[mid] == key) return true;
            if ( a[low] == a[mid] && a[mid] == a[high]){
                low=low+1;
                high = high-1;
                continue;
            }
            if ( a[low] <= a[mid]){
                if ( a[low] <= key && a[mid] >= key){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if ( a[mid] <= key && a[high] >= key){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return false;
    }
}
