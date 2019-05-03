package company.microsoft;

import java.util.*;

public class WordLadderI {
    public int ladderLength1(String start, String end, ArrayList<String> dictV) {
        Set<String> dictionary = new HashSet<>(dictV);
        Set<String> reached = new HashSet<String>();
        reached.add(start);
        dictionary.add(end);
        int distance = 1;
        while(!reached.contains(end)){
            Set<String> toAdd = new HashSet<String>();
            for(String each: reached){
                char[] chars = each.toCharArray();
                for(int i=0; i<chars.length; i++){
                    for(char c='a';c<='z'; c++ ){
                        chars[i] = c;
                        String word = new String(chars);
                        if(dictionary.contains(word)){
                            toAdd.add(word);
                            dictionary.remove(word);
                        }
                    }
                }
            }
            if(toAdd.size()==0){
                return 0;
            }
            distance++;
            reached = toAdd;
        }

        return distance;

    }

        public int ladderLength(String start, String end, ArrayList<String> dict){
                if(start.equals(end)){
                    return 1;
                }

                Deque<String> dq = new ArrayDeque<>();
                Set<String> visited = new HashSet<>();
                dq.add(start);
                visited.add(start);

                int steps =1 ;
                while(!dq.isEmpty()){
                    int size = dq.size();
                    for(int i=0;i<size; i++){
                        String s= dq.removeFirst();
                        for(String word: dict){
                            if(!visited.contains(word) && connected(s,word) ){
                                if(word.equals(end)){
                                    return steps;
                                }
                                visited.add(word);
                                dq.add(word);
                            }
                        }
                    }
                }

                return 0;
        }

    private boolean connected(String a, String b) {
        int diff = 0;
        for(int i = 0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
            }
            if(diff > 1){
                return false;
            }
        }
        return diff == 1;
    }

}
