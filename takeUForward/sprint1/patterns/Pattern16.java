package takeUForward.sprint1.patterns;

/*
A
BB
CCC
DDDD
EEEEE
*/

/*
1. find out how many lines to be printed ( outer loop )
2. figure out what is happening with each line and how do we connect it with outer loop
3.
 */

public class Pattern16 {
    public void pattern16(int n) {
        // n=5 5 lines outer loop i =1 -> 5
        // each line has i chars ( char start with A on first line & increment )
        char c = 'A';
        for ( int i=1; i<=n; i++){
            for ( int j=1; j<=i; j++){
                System.out.print(c);
            }
            c = (char) (c+1);
            System.out.println();
        }
    }

    public static void main(String[] args){
        Pattern16 obj = new Pattern16();
        obj.pattern16(5);
    }
}
