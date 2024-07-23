package striver_sde_sheet.arrays;
import java.util.ArrayList;
import java.util.List;

public class P118PascalSTriangle {

    // Pascal Triangle
    // Element at Rth Row and Cth Column is r-1 C c-1
    /*
    func long n ncr ( int n, inr r) {
        long res = 1;
        for ( int i=0; i<r; i++) {
            res = res * (n-i);
            res = res/(i+1);
        }
        return res;
     }
     */

    // Generate a row
    /*
    for ( int c=1; c<=n; c++){
    print( ncr(n-1, c-1);
    }
     */

    // O(n* r) needs optimization


    // 1
    // 1 1
    // 1 2 1
    // 1 3 3 1
    // 1 4 6 4 1
    // 1 5 10 10 5 1
    // Let's look at 6th row ( n-1 c r-1 )
    // 5c0 5c1 5c2 5c3 5c4 5c5
    // (1) (5/1) (5/1 * 4/2) (5/1 * 4/2 * 3/3)  (5/1 * 4/2 * 3/3 * 2/4 ) ( 5/1 * 4/2 * 3/3 * 2/4 * 1/5)
    // 1 **** 1
    // col ( 0 based index )
    // ans * something / column
    // ans * (row-column)/column



    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for ( int i = 1; i <= numRows; i++ ){
            res.add(generateRow(i));
        }
        return res;
    }

    private List<Integer> generateRow(int row) {
        List<Integer> rowList = new ArrayList<>();
        rowList.add(1);
        int ans = 1;
        for ( int col = 1; col< row; col++){
            ans = ans * ( row-col);
            ans /= (col);
            rowList.add(ans);
        }
        return rowList;
    }
}
