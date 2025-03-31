package CSES;

import java.util.Scanner;

public class P3Repetitions {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(findLongestRepetition(s));
    }

    private static int findLongestRepetition(String s) {
        if ( s.isEmpty() || s.length() == 0) return 0;
        int count = 1;
        int result = 1;
        for (int i=1; i<s.length(); i++){
            if ( s.charAt(i) == s.charAt(i-1)) {
                count++;
                result = Math.max(count, result);
            } else {
                count=1;
            }
        }
        return result;
    }
}

/*
 * CSES SUBMISSION GUIDELINES (for Java):
 *
 * DO:
 *   - Use a single class with *no* access modifier (i.e., not public).
 *   - Name the class anything (e.g., Main, Solver, etc.).
 *
 * DON'T:
 *   - Don't use 'package' statements — CSES won't compile files with them.
 *   - Don't declare your class as 'public' — you'll get a compilation error like:
 *       "class X is public, should be declared in a file named X.java"
 *
 * 🔁 Summary:
 *   Remove the 'package' line and the 'public' keyword from your class before submission.
 */