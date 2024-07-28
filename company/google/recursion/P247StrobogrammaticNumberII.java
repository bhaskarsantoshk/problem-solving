package company.google.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P247StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        char [] digits = {'0', '1', '6', '8', '9'};
        char[] chars = new char[n];
        helper(res, digits, map, 0, n-1, chars);
        return res;

    }

    private void helper(List<String> res, char[] digits, Map<Character, Character> map, int start, int end, char[] chars) {
        if ( start < end){
            if ( chars.length == 1 || chars[0] != '0') res.add(String.valueOf(chars));
            return;
        }
        for ( char c: digits){
            if ( start == end && c != map.get(c)) continue;
            chars[start] = c;
            chars[end] = map.get(c);
            helper(res, digits, map, start+1, end-1, chars);
        }
    }
}
