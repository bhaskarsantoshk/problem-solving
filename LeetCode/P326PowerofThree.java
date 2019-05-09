package LeetCode;

public class P326PowerofThree {
    public boolean isPowerOfThree(int n) {
        if(n > 1){
            while ( n % 3 == 0){
                n/=3;
            }
        }
        return n==1;
    }
}
