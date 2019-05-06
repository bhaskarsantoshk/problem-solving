package LeetCode;

public class P202HappyNumber {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = digitSquares(slow);
            fast = digitSquares(fast);
            fast = digitSquares(fast);
        }while(slow!= fast);
        return slow==1;
    }

    private int digitSquares(int num) {
        int sum = 0;
        while(num!=0){
            int rem  = num%10;
            sum+=  rem * rem;
            num/= 10;
        }
        return sum;
    }
}
