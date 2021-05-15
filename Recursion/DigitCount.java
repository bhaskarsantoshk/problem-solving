package Recursion;

import static Recursion.Print.print;

public class DigitCount {
    public static int countDigits(int n){
        int count = 0;
        while ( n != 0){
            n = n/10;
            count++;
        }
        return count;
    }

    public static void main(String[] args){
        print(countDigits(100));
        print(countDigitsRecursive(100));
    }

    public static int countDigitsRecursive (int n){
        if (n/10 == 0){
            return 1;
        }
        return 1+countDigitsRecursive(n/10);
    }
}
