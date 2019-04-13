package microsoft;

import java.util.ArrayList;

public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(ArrayList<Integer> a) {
        int j=0;
        int i=1;
        int count=1;
        while(i<a.size()){
            if(a.get(i).equals( a.get(j) )&& count<2){
                j++;
                count++;
            }
            else if(!a.get(i).equals(a.get(j))){
                j++;
                a.set(j, a.get(i));
                count=1;
            }
            i++;
        }

        return j+1;
    }
}
