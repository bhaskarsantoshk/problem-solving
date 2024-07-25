package company.google.arrays;

public class P66PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for ( int i=digits.length-1; i>=0; i--){
            carry += digits[i];
            digits[i] = carry % 10;
            carry /= 10;
            if ( carry == 0) return digits;
        }
        int[] res = new int[digits.length+1];
        if ( carry == 1){
            res[0] = 1;
            for ( int i=1; i<res.length; i++){
                res[i] = digits[i-1];
            }
        }
        return res;
    }

    public int[] plusOneOptimized(int[] digits) {
        for ( int i=digits.length-1; i>=0; i--){
            if ( digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
}
