package takeUForward.recursion.revision2;

public class P9SumOfDigitsInAGivenNumber {
    public int addDigits(int num) {
        if ( num == 0 ) return num;
        int res = (num%10 + addDigits(num/10));
        if ( res >= 10) return addDigits(res);
        return res;
    }
}
