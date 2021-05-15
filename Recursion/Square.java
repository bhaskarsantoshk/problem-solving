package Recursion;
// Direct Recursion
public class Square {
    public static int square(int n){
        if ( n == 0 ){
            return 0;
        }
        return square(n-1) * (2*n) -1;
    }
}
