package dynamic_programming.recursion;

public class Example_1_2_Nth_Power {
    int power(int x, int n){
        if(n==0){
            return 1;
        }
        if(x == 1){
            return 1;
        }
        return x * power(x, n-1);
    }
}
