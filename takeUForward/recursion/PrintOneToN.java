package takeUForward.recursion;

public class PrintOneToN {
    public void printNum(int i, int n){
        if ( i > n) return;
        System.out.println(i);
        printNum(i+1, n);
    }
}
