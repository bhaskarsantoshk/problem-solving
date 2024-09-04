package company.google.fromLCExperiences;

import java.util.*;

public class AncestralTree {

    /*
 Given an infinite ancestoral tree with child -> parent (both parents) relationship.
Find if two given persons are siblings
Follow up 1: Find if two given persons are first cousins
Follow up 2: Find lowest common ancestor
Note that it's not a usual tree with single relationship, every node here has two parents
     */
    public static void main(String[] args){
        Map<String, String[]> parentMap = Map.of(
                "A", new String[]{"P1", "P2"},
                "B", new String[]{"P1", "P2"},
                "C", new String[]{"P3", "P4"}
        );

        System.out.println(areSiblings("A", "B", parentMap)); // true
        System.out.println(areSiblings("A", "C", parentMap)); // false
    }

    public static boolean areSiblings(String a, String b, Map<String, String[]> parentMap) {
        String[] parentsA = parentMap.getOrDefault(a, new String[]{null, null});
        String[] parentsB = parentMap.getOrDefault(b, new String[]{null, null});
        return parentsA[0].equals(parentsB[0]) && parentsA[1].equals(parentsB[1])
                || parentsA[0].equals(parentsB[1]) && parentsA[1].equals(parentsB[0]);
    }

    public static boolean areFirstCousins(String a, String b, Map<String, String[]> parentMap){
        String[] parentsA = parentMap.getOrDefault(a, new String[]{null, null});
        String[] parentsB = parentMap.getOrDefault(b, new String[]{null, null});

        if ( areSiblings(a, b, parentMap)) return false;

        for ( String parentA: parentsA){
            for (String parentB: parentsB){
                if ( areSiblings(parentA, parentB, parentMap)) return true;
            }
        }
        return false;
    }

    public static String findLowestCommonAncestor(String a, String b, Map<String, String[]> parentMap){
        Queue<String> q = new LinkedList<>();
        if ( a!= null ){
            q.offer(a);
        } else {
            return b;
        }
        Set<String> ancestors = new HashSet<>();
        while (!q.isEmpty()){
            String current = q.poll();
            ancestors.add(current);
            String[] parents = parentMap.getOrDefault(current, new String[]{null, null});
            for (String parent: parents){
                if ( parent != null) q.offer(parent);
            }
        }

        q = new LinkedList<>();
        q.offer(b);
        while (!q.isEmpty()){
            String current = q.poll();
            if ( ancestors.contains(current)) return current;
            String[] parents = parentMap.getOrDefault(b, new String[]{null, null});
            for (String parent: parents) {
                if ( parent != null) q.offer(parent);
            }
        }
        return null;
    }


}
