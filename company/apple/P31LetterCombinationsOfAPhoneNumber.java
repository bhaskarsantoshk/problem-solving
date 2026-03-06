package company.apple;

import java.util.ArrayList;
import java.util.List;

public class P31LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] keyPad = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> combinations = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        f(digits, sb, combinations, 0, keyPad);
        return combinations;
    }

    private void f(String digits, StringBuilder sb, List<String> combinations, int index, String[] keyPad) {
        if ( index >= digits.length()){
            combinations.add(sb.toString());
            return;
        }

        String letters = keyPad[digits.charAt(index)-'0'];

        for ( char c: letters.toCharArray()){
            sb.append(c);
            f(digits, sb, combinations, index+1, keyPad);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

/*
           ""
       /    |    \
      a     b     c
    / | \ / | \ / | \
   d  e  f d  e  f d  e  f
 */
