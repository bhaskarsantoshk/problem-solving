package takeUForward.recursion.revision2;

import java.util.Vector;

public class P4ReverseAStringI {
    public Vector<Character> reverseString(Vector<Character> s) {
        reverse(s, 0, s.size()-1);
        return s;
    }

    private void reverse(Vector<Character> s, int left, int right) {
        if ( left >= right) return ;
        char temp = s.get(left);
        s.set(left, s.get(right));
        s.set(right, temp);
        reverse(s, left+1, right-1);
    }
}
