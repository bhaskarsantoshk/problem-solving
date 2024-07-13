package LeetCode;

import java.util.*;

public class P2751RobotCollisions {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Integer [] ids = new Integer[positions.length];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;  // Store indices
        }
        Arrays.sort(ids, Comparator.comparingInt(a -> positions[a]));
        Stack<Integer> stack = new Stack<>();
        for ( int id: ids){
            char c = directions.charAt(id);
            if ( c == 'R'){
                stack.push(id);
            } else {
                while ( stack.isEmpty() ){
                    if ( healths[stack.peek()] > healths[id]){
                        healths[stack.peek()]--;
                        healths[id] = 0;
                    } else if ( healths[stack.peek()] < healths[id]){
                        healths[id]--;
                        healths[stack.peek()] = 0;
                        stack.pop();
                    } else {
                        healths[id] = healths[stack.peek()] = 0;
                        stack.pop();
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for ( int health: healths){
            if ( health>0) res.add(health);
        }
        return res;
    }

    public static void main(String[] args){
        int[] healths = {2,17,9,15,10};
        int[] positions = {5,4,3,2,1};
        String dir = "RRRRR";
        P2751RobotCollisions obj = new P2751RobotCollisions();
        System.out.println(obj.survivedRobotsHealths(positions, healths, dir));
    }
}
