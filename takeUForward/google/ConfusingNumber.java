package takeUForward.google;

public class ConfusingNumber {
    public boolean isConfusingNumber(int n) {
        int num = n;
        int newNum = 0;
        while ( num != 0){
            int digit = num % 10;
            int rotated = getRoatedNum(digit);
            if ( rotated == -1) return false;
            newNum = newNum * 10 + rotated;
            num /=10;
        }

        return newNum != n;
    }

    private int getRoatedNum(int n){
        if ( n == 0) return 0;
        if ( n == 1) return 1;
        if ( n == 6) return 9;
        if ( n == 8) return 8;
        if ( n == 9) return 6;
        return -1;
    }

}
