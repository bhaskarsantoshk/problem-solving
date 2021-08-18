package company.amazon.leetcode;

public class P8StringToIntegerAtoi {
    public int myAtoi(String s) {
        if ( s.isEmpty() ) return 0;
        int index = 0, res = 0, sign = 1;
        while ( s.charAt(index) == ' '){
            index++;
        }
        s=s.trim(); // spaces at the end
        if ( s.charAt(index) == '-' || s.charAt(index) == '+'){
            sign = (s.charAt(index) == '-') ? -1: 1;
            index++;
        }
        while ( index < s.length() && s.charAt(index)>='0' && s.charAt(index)<='9'){
            if ( res > Integer.MAX_VALUE/10 ||
                    (res == Integer.MAX_VALUE/10 && (s.charAt(index)-'0') > Integer.MAX_VALUE/10)){
                return sign>0 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }
            res = res * 10 + (s.charAt(index++)-'0');
        }
        return res * sign;
    }
}
