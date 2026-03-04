package company.apple;

public class P4IntegerToRoman {
    public String intToRoman(int num) {
        String[] romanNum = {"M","CM", "D", "CD", "C","XC", "L", "XL", "X", "IX", "V", "IV" ,"I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for ( int i=0; i<values.length; i++){
            while ( num >= values[i] ){
                sb.append(romanNum[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
