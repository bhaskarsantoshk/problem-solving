package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args){
        int a[] = {3, 30, 34, 5, 9, 0, 0, 0, 0};
        ArrayList<Integer> al = new ArrayList<>();
        for(int x: a){
            al.add(x);
        }
        String result = largestNumber(al);
        System.out.println(result);
    }

    private static String largestNumber(ArrayList<Integer> al) {
        StringBuffer result = new StringBuffer();
        Node nums[] = new Node[al.size()];
        int i=0;
        for(Integer x: al){
            nums[i] = new Node(x);
            i++;
        }
        Arrays.sort(nums);
        System.out.println(nums);
        for(Node n: nums){
            if(n.number == 0 && result.length()!=0){
                continue;
            }
            result.append(n.number);
        }
        return result.toString();
    }

   static class Node implements Comparable<Node>{
        int number;
        Node(int num){
            this.number = num;
        }

       @Override
       public int compareTo(Node that) {
            String first = String.valueOf(this.number)+String.valueOf(that.number);
            String second = String.valueOf(that.number)+String.valueOf(this.number);
           return second.compareTo(first);
       }
   }
}
