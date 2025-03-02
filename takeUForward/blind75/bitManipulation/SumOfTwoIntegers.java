package takeUForward.blind75.bitManipulation;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int res = a^b;
        int carry = (a&b) << 1;
        if ( carry != 0) return getSum(res, carry);
        return res;
    }

    // 1 0 0 1
    // 1 1 0 1
    // --------
    //       0
    // if there is a 1 + 1 -> there will be left shift of 1
    // 1 0 or 0 1 or 1 1 -> (p^q) + (p&q) << 1
    // https://stackoverflow.com/a/15450315/5070050

}
