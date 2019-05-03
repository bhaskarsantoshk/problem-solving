package company.microsoft;

import java.util.ArrayList;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(ArrayList<Integer> a) {
        int i=0;
        int n= a.size();
        for(int num: a){
            if(i<2 || num!= a.get(i-2)){
                a.set(i, num);
                i++;
            }
        }
        return i;
    }
}

