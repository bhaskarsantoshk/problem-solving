package bytebybyte;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Duplicates {

    public List<Integer> findAllDuplicates(int []a){
        Set<Integer> res = new HashSet<>();
        for ( int i=0; i<a.length; i++){
            int index = Math.abs(a[i]) -1;
            if (a[index] <0){
                res.add(a[i]);
            }
            else{
                a[index] = -1 * a[index];
            }
        }

        for ( int i=0; i<a.length; i++){
            a[i] = Math.abs(a[i]);
        }
        return new ArrayList<>(res);
    }

}
// Note each value in the array is 1 <= x <= length of the array
// brute force : N^2
// T = N , S = N add each a set, every new item gets checked in set if it exists already
// Sort and check adjacent, N log N
/*

Best approach is to go through each element ,flip the sign of element which is at number-1 th index.

if we find negative element, it's a duplicate

[ 2 , 1, 2, 1] dup []
[ 2, -1, 2, 1] dup []
[ -2, -1, 2, 1] dup [2]
[ -2, -1, 2, 1] dup [2,1]
 */
