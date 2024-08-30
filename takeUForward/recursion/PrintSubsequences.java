package takeUForward.recursion;

public class PrintSubsequences {
    public static void printSubsequences(String input) {

        f( input, 0, "");
    }

    private static void f(String input, int index, String s) {
        if ( index == input.length()-1){
            System.out.println(s);
            return;
        }
        f( input, index+1, s+input.charAt(index));
        f(input, index+1, s);
    }

    public static void printSubsequencesUsingPowerSet(String input) {
        int n = input.length();
        for ( int num=0; num< (1<<n); num++){
            StringBuilder sb = new StringBuilder();
            for ( int i=0; i<n; i++){
                if ( (num & (1<<i)) != 0){
                    sb.append(input.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
