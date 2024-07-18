package Recursion;

public class PrintOneToNUsingBacktracking {
    public void print(int i, int n){
        if (i < 1) return;
        print(i-1, n);
        System.out.println(i);
    }
}
