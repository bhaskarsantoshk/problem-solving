package takeUForward.recursion.revision4;

public class P16SumOfDigitsInAGivenNumber {
    public int addDigits(int num) {
        if ( num < 10) return num;
        int res = addRecusrively(num);
        if ( res >= 10) return addDigits(res);
        return res;
    }

    private int addRecusrively(int num) {
        if ( num == 0) return 0;
        return num%10 + addRecusrively(num/10);
    }
}
