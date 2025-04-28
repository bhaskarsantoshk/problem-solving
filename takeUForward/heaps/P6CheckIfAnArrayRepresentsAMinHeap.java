package takeUForward.heaps;

public class P6CheckIfAnArrayRepresentsAMinHeap {
    public boolean isHeap(int[] nums) {
        int n = nums.length;
        for ( int i=n/2-1; i>=0; i--){
            int left = 2 * i+1;
            int right = 2*i+2;
            if ( left < n && nums[left] < nums[i]) return false;
            if ( right < n && nums[right] < nums[i]) return false;
        }
        return true;
    }
}
