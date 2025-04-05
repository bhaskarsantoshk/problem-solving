package takeUForward.bitManipulation;

public class P2BinaryToDecimal {
    public static int convert(int N, String str) {
        int num = 0;
        int p2=1;
        for ( int i=N-1; i>=0; i--){
            if ( str.charAt(i) =='1'){
                num += p2;
            }
            p2 *= 2;
        }
        return num;
    }
}
