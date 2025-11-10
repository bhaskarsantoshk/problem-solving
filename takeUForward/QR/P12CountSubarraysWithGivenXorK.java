package takeUForward.QR;

public class P12CountSubarraysWithGivenXorK {
    public int subarraysWithXorK(int[] nums, int k) {
        int count = 0;
        for ( int i=0; i<nums.length; i++){
            int xor = 0;
            for ( int j=i; j<nums.length; j++){
                xor ^= nums[j];
                if ( xor == k) count++;
            }
        }
        return count;
    }
}
