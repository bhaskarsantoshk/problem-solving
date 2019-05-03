package microsoft;

public class TrailingZerosinFactorial {
    public int trailingZeroes(int A) {
        int fives=0;
        while(A!=0){
            A=A/5;
            if(A!=0) {
                fives+=A;
            }
        }
        return fives;
    }
}
