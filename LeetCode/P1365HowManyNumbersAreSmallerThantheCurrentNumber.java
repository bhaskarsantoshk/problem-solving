class P1365HowManyNumbersAreSmallerThantheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int count[] = new int[101];
        
        for ( int num: nums){
            count[num]++;
        }
        
        // cumulative sum
        for ( int i=1; i<count.length; i++){
            count[i] += count[i-1];
        }
        
        int res [] = new int[nums.length];
        for ( int i=0; i<nums.length; i++){
            if ( nums[i] == 0){
                res[i]= 0;
            }
            else{
                res[i] = count[nums[i]-1];
            }
        }
        return res;
    }
}
