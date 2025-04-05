package takeUForward.bitManipulation;

public class P8RemoveTheLastSetBit {
    static int removeTheLastSetBit( int n){
        return n & (n-1);
    }
}
