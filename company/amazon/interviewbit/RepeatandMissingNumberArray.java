package company.amazon.interviewbit;

public class RepeatandMissingNumberArray {
    public static int[] repeatedNumber(final int[] a) {
        int xor = 0;
        for ( int num: a){
            xor ^= num;
        }
        for ( int i = 1; i <= a.length; i++){
            xor ^= i;
        }

        int setBit = 0;
        while ( (xor & (1 << setBit)) == 0 ){
            setBit++;
        }

        int first = 0, second = 0;
        for ( int num : a){
            if ( (num & ( 1 << setBit) ) != 0){
                first ^= num;
            } else {
                second ^= num;
            }
        }

        for ( int i=1; i<= a.length; i++){
            if ( (i & ( 1 << setBit)) != 0 ){
                first ^= i;
            } else {
                second ^= i;
            }
        }

        int res[] = new int[2];
        for ( int num: a){
            if ( first == num ){
                res[0] = first;
                res[1] = second;
            } else if ( second == num ){
                res[0] = second;
                res[1] = first;
            }
        }
        return res;
    }
}
