package company.apple;

import java.util.HashSet;
import java.util.Set;

public class P59HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while ( n != 1 && !seen.contains(n) ){
            seen.add(n);
            n = getSquaresSum(n);
        }
        return n == 1;
    }

    private int getSquaresSum(int n) {
        int sum = 0;
        while ( n!= 0){
            int rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        return sum;
    }
}
