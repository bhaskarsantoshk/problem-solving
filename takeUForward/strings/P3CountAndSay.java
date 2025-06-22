package takeUForward.strings;

public class P3CountAndSay {
    public String countAndSay(int n) {
        if ( n == 1) return "1";
        String prevResult = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int count =1;
        int i=1;
        for ( i=1; i<prevResult.length(); i++){
            if ( prevResult.charAt(i) == prevResult.charAt(i-1)) count++;
            else {
                sb.append(count);
                sb.append(prevResult.charAt(i-1));
                count = 1;
            }
        }
        sb.append(count);
        sb.append(prevResult.charAt(i-1));
        return sb.toString();
    }
}
