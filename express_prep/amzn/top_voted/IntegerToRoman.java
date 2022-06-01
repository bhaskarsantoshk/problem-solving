package express_prep.amzn.top_voted;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanNumbers = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer res = new StringBuffer();
        for ( int i=0; i<values.length; i++){
            while ( num >= values[i]){
                num-= values[i];
                res.append(romanNumbers[i]);
            }
        }
        return res.toString();
    }
}
