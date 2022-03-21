package company.amazon.leetcode;

import java.util.LinkedList;

public class P735AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<>();
        for ( int astroid: asteroids){
            if (astroid > 0){
                list.add(astroid);
            } else {
               while (!list.isEmpty() && list.getLast()>0 && list.getLast() < -astroid){
                   list.pollLast();
               }
               if ( list.isEmpty() && list.getLast() == -astroid ) {
                   list.pollLast();
               }
               else if ( list.isEmpty() || list.getLast() < 0 ){
                   list.add(astroid);
               }
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
