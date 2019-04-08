package dynamic_programming.recursion;

public class Example_1_1_SumOfNumbers {
    public int sum(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return n+sum(n-1);

    }

    //Non recursive

    public int sumIterative(int n){
        int sum= 0;
        for(int i=1; i<=n ;i++){
            sum+=i;
        }
        return sum;
    }
}
