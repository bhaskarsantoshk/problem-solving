package youtube.freeCodeCampOrg.dynamicProgrammingByCoderByte;

import java.util.HashMap;
import java.util.Map;

import static Utility.Utility.print;

public class CanConstruct {
    public static boolean canConstructRec(String targetWord, String[] words){
        if ( targetWord.isEmpty() ){
            return true;
        }
        for ( String word: words) {
            if ( targetWord.startsWith(word) ) {
                String suffix = targetWord.substring(word.length());
                if (canConstructRec(suffix, words)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(canConstructRec("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(canConstructRec("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
    }

    private static boolean canConstruct(String targetString, String[] wordBank) {
        Map<String, Boolean> memo = new HashMap<>();
        return canConstructMemoized(targetString, wordBank, memo);
    }

    private static boolean canConstructMemoized(String targetString, String[] wordBank, Map<String, Boolean> memo) {
        if ( memo.containsKey(targetString)) return memo.get(targetString);

        if ( targetString.isEmpty() ) return true;
        for ( String word: wordBank){
            if ( targetString.startsWith(word)){
                String suffix = targetString.substring(word.length());
                if (canConstructMemoized(suffix, wordBank, memo)){
                    memo.put(targetString, true);
                    return true;
                }
            }
        }
        memo.put(targetString, false);
        return false;
    }
}
