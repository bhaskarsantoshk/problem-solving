package takeUForward.recursion.revision;

public class P7ReverseAnArray {
    public static void main(String[] args){
        int [] a= {1,2,3,4,2};
        reverse(a, 0, a.length-1);
        for ( int num: a){
            System.out.print(num+" ");
        }
    }

    private static void reverse(int[] a, int l, int r) {
        if ( l >=r ) return;
        swap(a, l, r);
        reverse(a, l+1, r-1);
    }

    private static void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
