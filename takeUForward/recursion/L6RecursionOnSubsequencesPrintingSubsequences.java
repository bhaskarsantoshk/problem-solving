package takeUForward.recursion;

public class L6RecursionOnSubsequencesPrintingSubsequences {
    public static void printAllSubsequences(String s){
        f(0, s, "");
    }

    private static void f(int index, String s, String subsequence) {
        if ( index == s.length()) {
            System.out.println(subsequence);
            return;
        }
        // take
        f( index+1, s, subsequence+s.charAt(index));
        // notTake
        f(index+1, s, subsequence);
    }

    public static void printAllSubsequencesPowerSet(String str){
        int n = str.length();
        for ( int num=0; num < (1 << n) ; num++){
            String s = "";
            for ( int i=0; i<n; i++){
                if ( (num & (1 <<i)) != 0) s+=str.charAt(i);
            }
            System.out.println(s);
        }
    }

    public static void main(String args[]) {
        String s = "abc";
        System.out.println("All possible subsequences are: ");
        printAllSubsequences(s);
        printAllSubsequencesPowerSet(s);
    }
}
