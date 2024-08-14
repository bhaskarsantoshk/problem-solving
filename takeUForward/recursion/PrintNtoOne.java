package takeUForward.recursion;

public class PrintNtoOne {
    public void printNum(int n){
        if ( n == 0) return;
        System.out.println(n);
        printNum(n-1);
    }
}
