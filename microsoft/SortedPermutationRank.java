package microsoft;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedPermutationRank {
    public int findRank(String A) {
        int m = 1000003;
        int n = A.length();
        int fact[] = new int[n+1];
        fact[0]=fact[1]=1;
        for(int i=2;i<=n;i++){
            fact[i]=fact[i-1]*i;
            fact[i]=fact[i]%m;
        }
        int rank =0;
        final SortedSet<Character> set = new TreeSet<>();
        for(int i=n-1;i>=0;i--){
            char c= A.charAt(i);
            int less = ((TreeSet<Character>) set).headSet(c).size();
            rank += less * fact[n-1-i];
            rank %=m;
            set.add(c);
        }
        return rank+1;
    }
}
