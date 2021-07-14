package data_structures.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcher {
    public static void main(String[] args) {
        String s1 = "fabbbc";
        String s2 = ".ab*c";
        boolean res = regexMatch(s1, s2);

        Pattern pattern = Pattern.compile(s1);
        Matcher matcher = pattern.matcher(s2);

        if (res) {
            System.out.print(s1 + " " + s2 + " match");
        } else {
            System.out.print(s1 + " " + s2 + " did not match.");
        }
    }

    private static boolean regexMatch(String text, String pattern) {
        return regexMatch(text, pattern, 0, 0);
    }

    private static boolean regexMatch(String text, String pattern, int textIndex, int patternIndex) {
        // Both text and pattern reached the ends
        if ( text.length() == textIndex && pattern.length() == patternIndex){
            return true;
        }
        // Compare the characters at each index
        // First check is about "*" and second will be "."
        if ( patternIndex < pattern.length()-1 && pattern.charAt(patternIndex+1) == '*'){
            for ( int i= textIndex; i<= text.length(); i++){
                // example : a* can be empty string , a or aa, aaa etc.
                if ( regexMatch(text, pattern, i, patternIndex+2)){
                    return true;
                }
                if ( i >= pattern.length() ){
                    return false;
                }
                if ( pattern.charAt(patternIndex) != '.' && pattern.charAt(patternIndex) != text.charAt(i)){
                    return false;
                }
            }
        } else if ( textIndex < text.length() && patternIndex < pattern.length() ){
            // If it's a '.', we can match with anything. If it's not a '.', characters should match
            if ( pattern.charAt(patternIndex) == '.' || pattern.charAt(patternIndex) == text.charAt(textIndex)){
                return regexMatch(text, pattern, textIndex+1, patternIndex+1);
            }
        }
        return false;
    }
}
