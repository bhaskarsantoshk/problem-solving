package takeUForward.arrays.faqs;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public int[] pascalTriangleII(int r) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(List.of(1)));
        for ( int row=1; row<r; row++){
            List<Integer> prev = res.get(res.size()-1);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for ( int i=1; i<prev.size(); i++){
                cur.add(prev.get(i)+prev.get(i-1));
            }
            cur.add(1);
            res.add(cur);
        }
        return res.get(res.size()-1).stream().mapToInt(i->i).toArray();
    }
}
