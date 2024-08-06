package company.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P403FrogJump {
    public boolean canCross(int[] stones) {
        return canCross(stones, 0, 0);
    }

    private boolean canCross(int[] stones, int index, int lastJump) {
        if (index == stones.length) return true;
        for ( int i=index+1; i< stones.length ; i++){
            int jump = stones[i] - stones[index];
            if ( jump >= lastJump-1 && jump <= lastJump+1){
                if ( canCross(stones, i, jump)) return true;
            }
        }
        return false;
    }

    public boolean canCrossMemoized(int[] stones) {
        Map<Integer, Set<Integer>> memo = new HashMap<>();
        for (int stone : stones) {
            memo.put(stone, new HashSet<>());
        }
        return canCrossMemoized(stones, 0, 0, memo);
    }

    private boolean canCrossMemoized(int[] stones, int index, int lastJump, Map<Integer, Set<Integer>> memo) {
        int position = stones[index];
        if (memo.get(position).contains(lastJump)) {
            return false;
        }
        memo.get(position).add(lastJump);
        if (index == stones.length - 1) {
            return true;
        }
        for (int i = index + 1; i < stones.length; i++) {
            int jump = stones[i] - position;
            if (jump >= lastJump - 1 && jump <= lastJump + 1) {
                if (canCrossMemoized(stones, i, jump, memo)) {
                    return true;
                }
            }
        }
        return false;
    }
}
