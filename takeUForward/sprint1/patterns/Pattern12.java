package takeUForward.sprint1.patterns;

/*
1        1
12      21
123    321
1234  4321
1234554321
*/

/*
1. find out how many lines to be printed ( outer loop )
2. figure out what is happening with each line and how do we connect it with outer loop
3.
 */

public class Pattern12 {
    public void pattern12(int n) {
        // 1 8 spaces 1
        // 12 6 spaces 21
        // 123 4 spaces 321
        // 1234 2 spaces 4321
        // 12345 0 spaces 54321

        // n=5 5 lines outer loop i=1 -> 5
        // each line  contains 1->i 2*(n-i) spaces i->1

        for ( int i=1; i<=n; i++){
            for ( int j=1; j<=i; j++){
                System.out.print(j);
            }
            for ( int j=1; j<=2*(n-i); j++){
                System.out.print(" ");
            }
            for ( int j=i; j>=1; j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Pattern12 obj = new Pattern12();
        obj.pattern12(5);
    }
}
