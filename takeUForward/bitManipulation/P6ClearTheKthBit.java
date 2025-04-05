package takeUForward.bitManipulation;

public class P6ClearTheKthBit {
    static int clearKthBit(int n, int k){
        int mask = ~(1<<(k-1));
        return n&mask;
    }
}
