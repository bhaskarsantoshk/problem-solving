package takeUForward.blind75.bitManipulation;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int mask = 1;
        int bits = 0; // or ones
        for ( int i=0; i<32; i++){
            if ( (n & mask) != 0) bits++;
            mask = mask << 1; // n = n >> 1 ( arithmetic right shift )
            // or for signed n = n >>> 1 ( logical right shift )
        }
        return bits;
    }
}
