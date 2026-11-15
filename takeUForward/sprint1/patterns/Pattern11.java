package takeUForward.sprint1.patterns;

/*
1
01
101
0101
10101
*/

/*
1. find out how many lines to be printed ( outer loop )
2. figure out what is happening with each line and how do we connect it with outer loop
3.
 */

public class Pattern11 {
    public void pattern11(int n) {
        // 5 lines - outer loop i : 1 ->5
        // at each line , will print i numbers , odd numbered lines will start with 1 , even numbered  lines with 0
        int num = 1;
        for ( int i=1; i<=n; i++){
            num = i%2;
            for ( int j=1; j<=i; j++){
                System.out.print(num+" ");
                num = ( num== 1)?0:1;
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Pattern11 obj = new Pattern11();
        obj.pattern11(5);
    }
}
