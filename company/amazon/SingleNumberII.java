public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int result = 0;
        for (int i=0; i<32; i++){
            int count=0;
            for (int num: A){
                if ( (num & (1<<i)) != 0){
                    count++;
                }
            }
            result |= ((count%3)<<i);
        }
        return result;
    }
    
}
