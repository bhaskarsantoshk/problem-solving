package company.apple;

public class P3StringToIntegerAtoi {
    public int myAtoi(String s) {
        s = s.trim();
        if ( s.isEmpty()) return 0;
        int index = 0;
        int sign = 1;
        if ( s.charAt(0) == '-' || s.charAt(index) == '+'){
            sign = ( s.charAt(index) == '-') ? -1:1;
            index=1;
        }
        int res = 0;
        while ( index < s.length() && isDigit(s.charAt(index))){
            char c = s.charAt(index);
            if ( isOverflow(res, c-'0')){
                return sign == 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }
            res = res * 10 + (c-'0');
            index++;
        }
        return res * sign;
    }

    private boolean isOverflow(int num, int rem) {
        // num * 10 + rem < Integer.MAX_VALUE
        if ( num > Integer.MAX_VALUE/10  || (num == Integer.MAX_VALUE/10 && rem > Integer.MAX_VALUE%10))return true;
        return false;
    }

    private boolean isDigit(char c) {
        return c >='0' && c <='9';
    }
}
