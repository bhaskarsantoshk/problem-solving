package LeetCode;

public class P172FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int fives =0;
        while(n!=0){
            fives+= n/5;
            n=n/5;
        }
        return fives;
    }
}
