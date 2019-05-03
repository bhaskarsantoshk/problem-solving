package microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AllPermutations {
    public ArrayList<String> perumations(String s){
        ArrayList<String> results = new ArrayList<>();
        perumations("", s, results);
        return results;
    }

    private void perumations(String prefix, String suffix, ArrayList<String> results){
        if(suffix.length()==0){
            results.add(prefix);
        }
        else{
            for(int i=0; i<suffix.length() ; i++){
                perumations(prefix+suffix.charAt(i), suffix.substring(0,i)+suffix.substring(i+1), results);
            }
        }
    }

    public static void main(String[] args){
        AllPermutations obj = new AllPermutations();
        ArrayList<String> results = obj.perumations("abc");
        System.out.println(results);
    }


    public ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> a){
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        perumations(a,0, results, set);
        return results;
    }

    private void perumations(ArrayList<Integer> a , int start, ArrayList<ArrayList<Integer>> results, Set<ArrayList<Integer>> set){
        if(start>= a.size()){
            if(!set.contains(a)) {
                results.add(cloneList(a));
                set.add(a);
            }
        }
        else{
            for(int i= start; i<a.size(); i++){
                swap(a,start,i);
                perumations(a, start+1, results, set);
                swap(a,start, i);
            }
        }
    }

    private void swap(ArrayList<Integer> a, int i , int j){
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    public static ArrayList<Integer> cloneList(ArrayList<Integer> list) {
        ArrayList<Integer> clone = new ArrayList<Integer>(list.size());
        for (Integer item : list) clone.add(item);
        return clone;
    }
}
