package takeUForward.greedy;

public class P2498FrogJumpII {
    public int maxJump(int[] stones) {
        int res = stones[1] - stones[0];
        for ( int i=3; i<stones.length; i+=2) res = Math.max( res, stones[i]-stones[i-2]);
        for ( int i=2; i<stones.length; i+=2) res= Math.max(res, stones[i]-stones[i-2]);
        return res;
    }
}
