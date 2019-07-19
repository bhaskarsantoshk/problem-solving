package interviewbit.stacks_and_queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if ( A.isEmpty() || A == null){
            return result;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for ( int i=0; i<B; i++){
            if ( deque.isEmpty() ){
                deque.push(i);
            }
            else{
                while ( A.get(deque.peekFirst()) < A.get(i) ){
                    deque.pollFirst();
                }
                deque.push(i);
            }
        }
        result.add(A.get(deque.peekLast()));
        //System.out.println(result);
        for ( int i= B; i<A.size(); i++){
            if ( deque.peekLast() < i-B+1){
                deque.pollLast();
            }
            if ( deque.isEmpty()){
                deque.push(i);
            }
            else{
                while(A.get(deque.peekFirst()) < A.get(i)){
                    deque.pollFirst();
                }
                deque.push(i);
            }
            result.add(A.get(deque.peekLast()));
        }
        return result;
    }

    public static void main(String[] args){
        int a[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        ArrayList<Integer> A = new ArrayList<>();
        for ( int x: a){
            A.add(x);
        }
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        System.out.println(obj.slidingMaximum(A, 2));
    }
}
