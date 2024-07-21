package company.google;

import java.util.Stack;

public class P1717MaximumScoreFromRemovingSubstrings {
    public int maximumGain(String s, int x, int y) {
        String s1 = "ab", s2 = "ba";
        if ( x < y ){
            int temp = x;
            x = y;
            y = x;
            s1 = "ba";
            s2 = "ab";
        }
        return maxPoints ( s, s1, x) + maxPoints ( s, s2, y);
    }

    private int maxPoints(String s, String s1, int x) {
        return 0;
    }

    // DP vs Greedy
    // Possibly not DP because string shrinks upon removal and new combination comes

}
