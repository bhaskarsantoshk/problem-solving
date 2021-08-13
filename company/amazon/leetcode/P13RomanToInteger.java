package company.amazon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P13RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        map.put('A',0);
        int sum = 0;
        char prev = 'A';
        for ( char c: s.toCharArray()){
            if (map.get(c) > map.get(prev)){
                sum -= 2 * map.get(prev);
            }
            sum += map.get(c);
            prev = c;
        }
        return sum;
    }

    public static void main(String[] args){
        int res = romanToInt("IV");
    }
}
