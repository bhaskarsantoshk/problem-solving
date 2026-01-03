package takeUForward.recursion.revision4;

import java.util.ArrayList;

public class P11ReverseAStringI {
    public ArrayList<Character> reverseString(ArrayList<Character> s) {
        reverseString(s, 0, s.size()-1);
        return s;
    }

    private void reverseString(ArrayList<Character> s, int start, int end) {
        if ( start >= end) return ;
        swap(s, start, end);
        reverseString(s, start+1, end-1);
    }

    private void swap(ArrayList<Character> s, int start, int end) {
        char temp = s.get(start);
        s.set(start, s.get(end));
        s.set(end, temp);
    }
}
