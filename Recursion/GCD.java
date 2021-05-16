package Recursion;

public class GCD {
    public static int gcd ( int num1, int num2){
        if ( num1 < num2 ){
            return gcd ( num2, num1);
        }
        if ( num1 % num2 == 0){
            return num2;
        }
        return gcd(num2, num1%num2);
    }

    public static void main(String[] args){
        System.out.println(gcd(18,24));
        System.out.println(gcd(54,36));
    }


    public static int gcd1(int num1, int num2) {
        if (num1 == num2) {
            return num1;
        }
        if (num1 > num2) {
            return gcd1(num1-num2, num2);
        }
        else {
            return gcd1(num1, num2-num1);
        }
    }
}
