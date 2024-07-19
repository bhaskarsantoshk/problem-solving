package Recursion;

public class SumOfFirstNNumbers {
    public void sumParameterized ( int n){
        sumParameterized ( n, 0);
        System.out.println(sumFunctional(10));
    }

    private void sumParameterized(int i, int sum) {
        if ( i < 1) {
            System.out.println(sum);
            return;
        }
        sumParameterized ( i-1, sum+i);
    }

    public static void main (String[] args){
        SumOfFirstNNumbers obj = new SumOfFirstNNumbers();
        obj.sumParameterized(10);
    }

    public int sumFunctional(int n){
        if ( n < 0) return 0;
        return n + sumFunctional(n-1);
    }
}
