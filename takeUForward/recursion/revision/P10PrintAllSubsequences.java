package takeUForward.recursion.revision;

public class P10PrintAllSubsequences {
    public static void printSubsequences(String input) {
        StringBuilder sb = new StringBuilder();
        printSubsequences(0, sb, input);

    }

    private static void printSubsequences(int i, StringBuilder sb, String input) {
        if ( i >= input.length()) {
            System.out.println(sb.toString());
            return;
        }
        // take
        sb.append(input.charAt(i));
        printSubsequences(i+1, sb, input);
        // not take
        sb.deleteCharAt(sb.length()-1);
        printSubsequences(i+1, sb, input);
    }
}
