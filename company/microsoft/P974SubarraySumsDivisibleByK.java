package company.microsoft;

public class P974SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        // SUM[i,j] = SUM[0,j]-SUM[0,i-1]
        int mods[] = new int[k];
        int sum =0;
        for ( int i=0; i<nums.length; i++){
            sum += nums[i];
            sum= sum%k;
            if ( sum < 0) sum+=k;
            mods[sum]++;
        }
        int ans = 0;
        ans += (mods[0] * (mods[0]+1))/2; // f you want to count the sum of the first x numbers: 1 + 2 + 3 + ... + x

        for ( int i=1; i<k; i++){
            ans += ((mods[i]) * (mods[i]-1))/2; // How many ways can we choose 2 items from x items
        }
        return ans;
    }
}
