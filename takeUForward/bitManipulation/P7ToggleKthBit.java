package takeUForward.bitManipulation;

public class P7ToggleKthBit {
    static int toogleIthBit(int n, int k){
        int mask = 1<<(k-1);
        return n ^ mask;
    }
}
