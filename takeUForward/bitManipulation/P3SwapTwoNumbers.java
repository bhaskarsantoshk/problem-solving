package takeUForward.bitManipulation;

public class P3SwapTwoNumbers {
    public static void swapNumber(int a[], int b[]) {
        a[0] = a[0]^b[0];
        b[0] = a[0]^b[0];
        a[0]= a[0]^b[0];
    }
}
