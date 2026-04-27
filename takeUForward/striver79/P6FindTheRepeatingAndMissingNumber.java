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

    public int[] findMissingRepeatingNumbersOptimal(int[] nums) {
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
}
