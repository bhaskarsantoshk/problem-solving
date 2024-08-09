package company.google;

public class P162FindPeakElement {
    public int findPeakElementLinear(int[] nums) {
        if ( nums == null || nums.length == 0) return -1;
        if ( nums.length == 1) return 0;
        if ( nums[0] > nums[1]) return 0;
        int n = nums.length;
        if ( nums[n-1] > nums[n-2]) return n-1;
        for ( int i=1; i<n-1; i++){
            if ( nums[i] > nums[i-1] && nums[i] > nums[i+1] ) return i;
        }
        return -1;
    }

    public int findPeakElementBinarySearch(int[] nums) {
        if ( nums == null || nums.length == 0) return -1;
        if ( nums.length == 1) return 0;
        if ( nums[0] > nums[1]) return 0;
        int n = nums.length;
        if ( nums[n-1] > nums[n-2]) return n-1;
        int start = 1, end = n-2;
        while ( start <= end){
            int mid = start + (end-start)/2;
            if ( nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if ( nums[mid] > nums[mid-1]) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}
