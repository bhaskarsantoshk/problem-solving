package Recursion;

import static Recursion.DataFormatter.print;

public class Occurence {
    public static int getFirstOccurence(int[] a, int num, int index){
        if (index == a.length){
            return -1;
        }
        if (a[index] == num){
            return index;
        }
        return getFirstOccurence(a,num,index+1);
    }
    public static void main(String[] args){
        int a[] = {1,2,3,4,5,6};
        print(getFirstOccurence(a,3,0));
        print(getFirstOccurence(a,6,0));
        print(getFirstOccurence(a,8,0));
        print(getFirstOccurence(a,1,0));
    }
}
