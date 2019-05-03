package company.microsoft;

import java.util.ArrayList;

public class SortbyColor {
    public void sortColors(ArrayList<Integer> a) {
        int j=0, k= a.size()-1;

        for(int i=0;i<a.size();i++){
            if(a.get(i)==0){
                int temp = a.get(i);
                a.set(i, a.get(j));
                a.set(j, temp);
                j++;
            }
            else if(a.get(i)==2){
                int temp = a.get(i);
                a.set(i, a.get(k));
                a.set(k, temp);
                k--;
                i--;
            }
        }
    }

    private void swap(ArrayList<Integer> a, int x, int y) {
        int temp= a.get(x);
        a.set(x, a.get(y));
        a.set(y, temp);
    }
}
