package company.google.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if ( digits == null || digits.length() == 0) return res;
        String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Map<Character, char[]> keyPad = new HashMap<>();
        for ( char c='0'; c<='9'; c++ ){
            keyPad.put(c, keys[c-'0'].toCharArray());
        }
        StringBuilder sb = new StringBuilder();
        backtrack( digits, 0, digits.length(), res, keyPad, sb);
        return res;
    }

    private void backtrack(String digits, int index, int length, List<String> res,
                           Map<Character,char[]> keyPad, StringBuilder prefix) {
        if ( index >= length){
            res.add(prefix.toString());
            return;
        }
        for ( char c: keyPad.get(digits.charAt(index))){
            prefix.append(c);
            backtrack(digits, index+1, digits.length(), res, keyPad, prefix);
            prefix.deleteCharAt(index);
        }
    }
}
