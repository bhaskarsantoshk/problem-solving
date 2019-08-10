package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
    public void nextPermutation(ArrayList<Integer> a) {
        int index1 = -1;
        for ( int i=0; i< a.size()-1; i++){
            if ( a.get(i) < a.get(i+1) ){
                 index1 = i;
            }
        }
        System.out.println(index1);
        if ( index1 == -1 ){
            Collections.sort(a);
            return;
        }
        int index2 = a.size()-1;
        while ( index2 > index1){
            if ( a.get(index2) > a.get(index1) ){
                break;
            }
            index2--;
        }
        System.out.println(index2);
        swap ( a,index1,index2);
        System.out.println(a);
        reverse(a, index1+1, a.size()-1);
        System.out.println(a);
    }

    private void reverse(ArrayList<Integer> a, int start, int end) {
        while ( start < end ){
            swap(a, start++, end--);
        }
    }

    private void swap(ArrayList<Integer> a, int index1, int index2) {
        int temp = a.get(index1);
        a.set(index1, a.get(index2));
        a.set(index2, temp);
    }



    public static void main(String[] args){
        int a[]= { 768, 506, 59, 854, 422};
        NextPermutation obj = new NextPermutation();
        ArrayList<Integer> al = new ArrayList<>();
        for ( int num: a){
            al.add(num);
        }
        obj.nextPermutation(al);
        System.out.println(al);
    }
}
