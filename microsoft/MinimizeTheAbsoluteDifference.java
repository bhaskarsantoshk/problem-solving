package microsoft;

import java.util.ArrayList;

public class MinimizeTheAbsoluteDifference {
    public int solve(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) {
        int i=0, j=0, k=0;
        int diff =Integer.MAX_VALUE;
        int index=0;
        while(i<a.size() && j<b.size()&& k < c.size()){
            int maximum = Math.max(Math.max(a.get(i), b.get(j)), c.get(k));
            int minimum= Math.min((Math.min(a.get(i), b.get(j))), c.get(k));
            if(diff > Math.abs(maximum-minimum)){
                diff = Math.abs(maximum-minimum);
                index=i;
            }
            if(a.get(i).equals( minimum)){
                i++;
            }
            else if(b.get(j).equals(minimum)){
                j++;
            }
            else{
                k++;
            }
        }
        return diff;
    }
}
