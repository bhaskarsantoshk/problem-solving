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

    private static boolean regexMatch(String s1, String s2) {
    }
}
