package takeUForward.arrays;

public class P1Sum {
    public  int sum(int arr[], int n) {
        int sum =0;
        for ( int num: arr) sum+= num;
        return sum;
    }
}
