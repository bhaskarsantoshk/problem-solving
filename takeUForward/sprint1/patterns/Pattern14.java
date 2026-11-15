package takeUForward.sprint1.patterns;

/*
A
AB
ABC
ABCD
ABCDE
*/

/*
1. find out how many lines to be printed ( outer loop )
2. figure out what is happening with each line and how do we connect it with outer loop
3.
 */

public class Pattern14 {
    public void pattern14(int n) {
        // n=5 5 lines outer loop i =1 -> 5
        // each line again i chars ( char start with A on each line & increment )
        for ( int i=1; i<=n; i++){
            char c = 'A';
            for ( int j=1; j<=i; j++){
                System.out.print(c);
                c = (char) (c+1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Pattern14 obj = new Pattern14();
        obj.pattern14(5);
    }
}
