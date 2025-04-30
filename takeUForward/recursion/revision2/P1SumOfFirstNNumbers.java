package takeUForward.recursion.revision2;

public class P1SumOfFirstNNumbers {
    public int NnumbersSum(int N) {
        if ( N == 0) return 0;
        return N+NnumbersSum(N-1);
    }

    public int NnumbersSum2(int N) {
        if ( N == 0) return 0;
        return NnumbersSum2(N-1)+N;
    }
}
