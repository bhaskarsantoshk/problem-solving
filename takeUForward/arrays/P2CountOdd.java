package takeUForward.arrays;

public class P2CountOdd {
    public int countOdd(int[] arr, int n) {
        int count = 0;
        for ( int num: arr) {
            if (num%2 ==1) count++;
        }
        return count;
    }
}
