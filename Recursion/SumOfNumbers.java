package Recursion;

public class SumOfNumbers {
    public static int sumOfAll ( int num ){
        if ( num <= 0 ) return 0;
        if ( num == 1){
            return num;
        }
        return num + sumOfAll(num-1);
    }

    public static void main( String args[] ) {
        int input = 5;
        int sum = sumOfAll(input);
        System.out.println(sum);
    }
}
