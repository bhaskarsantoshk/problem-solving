package express_prep.amzn.top_voted;

public class StringToIntegerAtoI {
    public static int  myAtoi(String s) {
        if ( s == null || s.isEmpty() ) return 0;
        s = s.trim();
        int index = 0, res = 0, sign = 1;
        if ( !s.isEmpty() && (s.charAt(index) == '-' || s.charAt(index) == '+' )){
            sign = ( s.charAt(index) == '-') ? -1: 1;
            index++;
        }
        while ( index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
            char c = s.charAt(index);
            if ( res > Integer.MAX_VALUE/10 || ( res == Integer.MAX_VALUE/10 && c-'0' > Integer.MAX_VALUE%10) ){
                return sign == 1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }
            res = res * 10 + (c-'0');
            index++;
        }
        return res * sign;
    }

    public static void main(String[] args){
        System.out.println(myAtoi("2147483648"));
    }
}
