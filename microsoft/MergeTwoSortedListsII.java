package microsoft;

import java.util.ArrayList;

public class MergeTwoSortedListsII {
    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        for(int index1=0, index2=0; index2<b.size(); index1++){
            if(index1==a.size() || b.get(index2) < a.get(index1)){
                a.add(index1, b.get(index2++));
            }
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(4);
        b.add(6);
        merge(a, b);
        System.out.println(a);
    }
}
