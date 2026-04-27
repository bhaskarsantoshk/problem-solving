package takeUForward.striver79;

public class P6FindTheRepeatingAndMissingNumber {
    public int[] findMissingRepeatingNumbersBruteForce(int[] nums) {
        int missing = -1, repeating = -1;
        int n = nums.length;
        for ( int i=1; i<=n; i++){
            int count = 0;
            for ( int j=0; j<n; j++){
                if (  nums[j] == i) count++;
            }
            if ( count == 2) repeating = i;
            else if ( count == 0) missing = i;
            if ( repeating != -1 && missing != -1) break;
        }
        return new int[] { repeating, missing};
    }


    public int[] findMissingRepeatingNumbersBetter(int[] nums) {
        int missing = -1, repeating = -1;
        int n = nums.length;
        int[] hash = new int[n+1];
        for ( int num: nums) hash[num]++;
        for ( int i=1; i<=n; i++){
            if ( hash[i] == 2) repeating = i;
            else if ( hash[i] == 0) missing = i;
            if ( repeating != -1 && missing != -1) break;
        }
        return new int[] { repeating, missing};
    }

    public int[] findMissingRepeatingNumbersOptimal1(int[] nums) {
        int n = nums.length;
        long sumOfN =  ((long) n * (n+1))/2;
        long sumOfSquareN = ((long) n * (n+1)* (2L *n+1))/6;
        long S = 0;
        long S2 = 0;
        for ( int num: nums){
            S+= num;
            S2 += ((long) num * num);
        }
        long xMinusy = S - sumOfN;
        long xPlusy = (S2-sumOfSquareN)/xMinusy;

        long repeat =(xPlusy - xMinusy) / 2;
        long missing = xPlusy-repeat;

        return new int[]{Math.toIntExact(repeat), Math.toIntExact(missing)};
    }

    public int[] findMissingRepeatingNumbersOptimal2(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for ( int i=0; i<n; i++){
            xor ^= nums[i];
            xor ^= (i+1);
        }
        int bitNo = 0;
        while ( true ){
            if ( (xor & (1 << bitNo)) != 0) break;
            bitNo++;
        }
        int zero = 0;
        int one = 0;
        for ( int i=0; i < n; i++){
            if ( (nums[i] & ( 1 << bitNo)) != 0) one ^= nums[i];
            else zero ^= nums[i];
        }
        for ( int i=1; i<=n; i++){
            if ( (i & (1 << bitNo)) != 0) one ^= i;
            else zero ^= i;
        }

        int count = 0;
        for ( int i=0; i<nums.length; i++){
            if ( zero == nums[i]) count++;
        }
        if ( count == 2){
            return new int[]{zero, one};
        }
        return new int[]{one, zero};
    }
}
