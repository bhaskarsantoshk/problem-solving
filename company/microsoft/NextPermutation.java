package company.microsoft;

import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {
    public static void main(String[] args){
        ArrayList<Integer> a= new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        //nextPermutation(a);
    }
    public void nextPermutation(ArrayList<Integer> a) {
        int p =-1;
        int q= -1;

        for(int i=a.size()-2;i>=0; i--){
            if(a.get(i) < a.get(i+1)){
                p = i;
                break;
            }
        }
        for(int i=a.size()-1 ; i>p; i--){
            if(a.get(i) > a.get(p)){
                q=i;
                break;
            }
        }

        if(p==0 && q==0){
            Collections.reverse(a);
            return;
        }

        int temp = a.get(p);
        a.set(p, a.get(q));
        a.set(q, temp);

        if(p<a.size()-1){
            reverse(a,p+1, a.size()-1);
        }

        //System.out.println(a);

    }

    public void reverse(ArrayList<Integer> a, int start, int end){
        while(start < end){
            int temp= a.get(start);
            a.set(start, a.get(end));
            a.set(end, temp);
            start++;
            end--;
        }
    }
}

