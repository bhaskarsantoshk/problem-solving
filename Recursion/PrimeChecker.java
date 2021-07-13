package Recursion;

public class PrimeChecker {
    public static boolean isPrime(int num){
      if ( num == 2){
          return true;
      }
      return isPrime(num, 2);
    }

    private static boolean isPrime(int num, int i) {
        if ( num % i == 0){
            return false;
        }
        if ( i >= num/i){
            return true;
        }
        return isPrime(num, i+1);
    }

    public static void main(String[] args){
        System.out.println(isPrime(43));
    }
}
