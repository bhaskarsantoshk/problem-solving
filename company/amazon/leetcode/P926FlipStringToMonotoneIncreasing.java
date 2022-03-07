package company.amazon.leetcode;

public class P926FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int flips=0, ones = 0;
        for ( int i=0; i<s.length(); i++){
            if ( s.charAt(i) == '0'){
                if (ones == 0) continue;
                else flips++;
            } else {
                ones++;
            }
            flips = Math.min(flips, ones);
        }
        return flips;
    }
}
