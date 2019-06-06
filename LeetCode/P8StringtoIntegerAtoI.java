package LeetCode;


import karumanchi.recursion_and_backtracking.TowerOfHanoi;

public class P8StringtoIntegerAtoI {
    public  int myAtoi(String str) {
        int index = 0;
        int sign = 1;
        int total = 0;

        if ( str.length() == 0) return 0;

        while ( index < str.length() && str.charAt(index) == ' '){
            index++;
        }

        if ( str.length() == index ){
            return 0;
        }

        if (str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1: -1;
            index ++;
        }

        while ( index < str.length() ){
            int c = str.charAt(index);
            int digit = c - '0';

            if ( !isDigit(digit)){
                break;
            }

            if (isOverFlow(total, digit)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE ;
            }
            total = total * 10 + digit ;
            index++;
        }

        return total * sign ;
    }

    private boolean isOverFlow(int total, int digit) {
        if ( total > Integer.MAX_VALUE/10 || ( total== Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10)){
            return false;
        }
        return true;
    }

    public boolean isDigit(int digit){
        return digit>=0 && digit<=9 ;
    }

}
