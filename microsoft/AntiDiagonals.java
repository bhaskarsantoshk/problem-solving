package microsoft;
import java.util.ArrayList;
public class AntiDiagonals {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<A.size() * 2 -1; i++){
            result.add(getDiagonal(i, A));
        }
        return result;
    }

    private ArrayList<Integer> getDiagonal(int level, ArrayList<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<= level; i++){
            int j= level -i;
            if(i<a.size() && j<a.size()){
                result.add(a.get(i).get(j));
            }
        }
        return result;
    }
}
