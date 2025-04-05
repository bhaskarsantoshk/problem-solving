package takeUForward.bitManipulation;

public class P11NumberOfFlips {
    public static int numberOfFlips(int a, int b) {
        int xor = a^b;
        int ans = 0;
        while ( xor > 0){
            xor = xor & (xor-1); // clears the right most set bit
            ans++;
        }
        return ans;
    }


    public static int numberOfFlips2(int a, int b) {
        int xor = a^b;
        int ans = 0;
        for ( int i=0; i<=31; i++){
            if (( xor & (1<<i) ) != 0) ans++;
        }
        return ans;
    }
}
