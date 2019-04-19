package LeetCode;

public class P7ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while( x != 0){
            int rem = x % 10;
            int newResult = result * 10 + rem;
            if( (newResult-rem)/10 != result){
                return 0;
            }
            result = newResult;
            x= x/10;
        }
        return result;
    }
}
