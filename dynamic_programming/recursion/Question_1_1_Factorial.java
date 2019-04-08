package dynamic_programming.recursion;

public class Question_1_1_Factorial {
    public long factorial(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    public int factorialIterative(int n){
        int factorial =1;
        for(int i=1; i<=n; i++){
            factorial*= i;
        }
        return factorial;
    }
}
