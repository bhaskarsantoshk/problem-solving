package takeUForward.strings;
import java.util.*;

public class ReverseAStringII {
    public void reverseString(Vector<Character> s) {
        int start = 0, end = s.size()-1;
        while ( start < end){
            char temp = s.get(start);
            s.set(start, s.get(end));
            s.set(end, temp);
            start++;
            end--;
        }
    }
}
