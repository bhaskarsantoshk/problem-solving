package LeetCode.explore.arrays;
import java.util.HashSet;
import java.util.Set;

class CheckIfNandItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for ( int num: arr){
            if ( set.contains(2*num) ||  (set.contains(num/2) && num == num/2 * 2)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}