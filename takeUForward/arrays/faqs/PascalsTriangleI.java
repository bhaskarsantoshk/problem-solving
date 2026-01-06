package takeUForward.arrays.faqs;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleI {
    public int pascalTriangleI(int r, int c) {
        if ( c < 0 || c > r) return -1;

        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        for ( int row=1; row<=r; row++){
            List<Integer> prev = res.get(row-1);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for ( int i=1; i<prev.size(); i++){
                cur.add(prev.get(i)+prev.get(i-1));
            }
            cur.add(1);
            res.add(cur);
        }
        return res.get(r).get(c);
    }
}
