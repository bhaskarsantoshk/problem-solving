package LeetCode.explore.recursion;

public class KthSymbolinGrammar {

    public int kthGrammar(int N, int K) {
        return kth(K-1);
    }

    private int kth(int k){
        if ( k== 0) return 0;
        if (k%2 == 0) return kth(k/2);
        return reverse(kth(k/2));
    }

    private int reverse(int kth) {
        return (kth == 0) ? 1:0;
    }

}