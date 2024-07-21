package company.microsoft.backtracking;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if ( digits == null || digits.length() == 0) return res;
        Map<Character, char[]> kepad = new HashMap<>();
        String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for ( char c='0'; c<='9'; c++){
            kepad.put((char) (c), keys[c-'0'].toCharArray());
        }
        StringBuilder sb = new StringBuilder();
        backtrack(digits, res, 0, digits.length(), kepad,sb);
        return res;
    }

    private void backtrack(String digits, List<String> res, int index, int length, Map<Character,char[]> kepad, StringBuilder prefix) {
        if ( index >= length){
            res.add(prefix.toString());
            return;
        }
        for ( char c: kepad.get(digits.charAt(index))){
            prefix.append(c);
            backtrack(digits, res, index+1, length, kepad, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
}
