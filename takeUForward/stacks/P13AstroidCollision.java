package takeUForward.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P13AstroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> res = new ArrayList<>();
        for ( int i=0; i<asteroids.length; i++){
            // if we see a positive number, let's push it to list/stack
            // if stack contains a positive num, it will be fine becase same direction
            // if stack contains negative at top, though it goes opposite, it will not collide as it's past
            if( asteroids[i] > 0) res.add(asteroids[i]);
            else {
                // multiple scenarios here
                // if there is a negative number at top. you can push
                // while there is a smaller positive number at top - you need to pop
                // equal but positive - pop and move i
                while ( ! res.isEmpty() && res.get(res.size()-1) > 0 && res.get(res.size()-1) < Math.abs(asteroids[i])) {
                    res.remove(res.size()-1); // stack.pop()
                }
                if ( res.isEmpty() || res.get(res.size()-1) < 0) res.add(asteroids[i]);
                else if ( res.get(res.size()-1) == Math.abs(asteroids[i] )) {
                    res.remove(res.size()-1);
                }
            }
        }
        int[] resultArr = new int[res.size()];
        for ( int i=0; i<resultArr.length; i++){
            resultArr[i] = res.get(i);
        }
        return resultArr;
    }

}
