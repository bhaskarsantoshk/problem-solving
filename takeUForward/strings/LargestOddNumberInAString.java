package takeUForward.strings;

public class LargestOddNumberInAString {
    public String largeOddNum(String s) {
        int right = s.length()-1;
        while ( right >=0){
            if ((int)(s.charAt(right)-'0') % 2 == 1) break;
            right--;
        }
        int left = 0;
        while ( left < s.length()){
            if ( s.charAt(left) != '0') break;
            left++;
        }
        if ( left > right) return "";
        String result = s.substring(left, right+1);
        return result.isEmpty() ? "" : result;
    }
}
