package takeUForward.greedy.revision;

public class P11ValidString {
    public static boolean checkValidString(String s) {
        return isValidString(s, 0, 0);
    }

    private static boolean isValidString(String s, int index, int count) {
        if ( count < 0) return false;
        if ( index >= s.length()){
            return count==0;
        }
        if ( s.charAt(index) == '(') return isValidString(s, index+1, count+1);
        if ( s.charAt(index) == ')') return isValidString(s, index+1, count-1);
        if (s.charAt(index) == '*'){

            return isValidString(s, index+1, count+1) || isValidString(s, index+1, count-1)
                    || isValidString(s, index+1, count);
        }
        return false;
    }

    public static boolean checkValidStringOptimized(String s) {
        int min = 0, max = 0;
        for ( int i=0; i<s.length(); i++){
            if ( s.charAt(i) == '('){
                min++;
                max++;
            } else if ( s.charAt(i) == ')'){
                min--;
                max--;
            } else{
                min--;
                max++;
            }
            if ( max < 0) return false;
            if ( min < 0) min = 0;
        }
        return min == 0;
    }
}
