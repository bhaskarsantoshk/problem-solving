package express_prep.amzn.top_voted;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if ( digits == null || digits.length() == 0) return result;
        Map<Character, char[]> letterMap = new HashMap<>();
        letterMap.put('0', new char[]{});
        letterMap.put('1', new char[]{});
        letterMap.put('2', new char[]{'a','b','c'});
        letterMap.put('3', new char[]{'d', 'e', 'f'});
        letterMap.put('4', new char[]{'g','h', 'i'});
        letterMap.put('5', new char[]{'j','k','l'});
        letterMap.put('6', new char[]{'m','n','o'});
        letterMap.put('7', new char[]{'p','q','r','s'});
        letterMap.put('8', new char[]{'t','u','v'});
        letterMap.put('9', new char[]{'w','x','y','z'});
        StringBuilder sb = new StringBuilder();
        backtrack(sb, digits, letterMap, result);
        return result;
    }

    private void backtrack(StringBuilder prefix, String digits, Map<Character,char[]> letterMap, List<String> result) {
        if (prefix.length() == digits.length()){
            result.add(prefix.toString());
            return;
        }
        for ( char c: letterMap.get(digits.charAt(prefix.length()))){
            prefix.append(c);
            backtrack(prefix, digits, letterMap, result);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
}
