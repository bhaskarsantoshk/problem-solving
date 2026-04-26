package takeUForward.striver79;

import java.util.HashMap;
import java.util.Map;

public class P5CountSubarraysWithGivenXorK {
    public int subarraysWithXorKBruteForce(int[] nums, int K) {
        int count = 0;
        for ( int i=0; i<nums.length; i++){
            for ( int j= i; j<nums.length; j++){
                int xor = 0;
                for ( int k=i; k<=j; k++) xor ^= nums[k];
                if (xor == K) count++;
            }
        }
        return count;
    }
    public int subarraysWithXorKBetter(int[] nums, int K) {
        int count = 0;
        for ( int i=0; i<nums.length; i++){
            int xor = 0;
            for ( int j= i; j<nums.length; j++) xor ^= nums[j];
            if (xor == K) count++;
        }
        return count;
    }

    public int subarraysWithXorKOptimal(int[] nums, int K) {
        int count = 0;
        // x = xr ^ k
        Map<Integer, Integer> map = new HashMap<>();
        int xr = 0;
        map.put(0,1);
        for ( int i=0; i<nums.length; i++){
            xr ^= nums[i];
            count += map.getOrDefault(xr^K,0);
            map.put(xr, map.getOrDefault(xr,0)+1);
        }
        return count;
    }
}
