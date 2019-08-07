package interviewbit.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestSequencewithGivenPrimes {
    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        int [] primes= { A, B, C};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(A);
        minHeap.offer(B);
        minHeap.offer(C);
        ArrayList<Integer> result = new ArrayList<>();
        Integer lowestnumber = 0;
        Set<Integer> unique = new HashSet<>();
        unique.add(A); unique.add(B); unique.add(C);
        while ( result.size() < D){
            Integer currentNode = minHeap.poll();

            if ( currentNode > lowestnumber){
                result.add(currentNode);
                lowestnumber = currentNode;
            }

            for ( int prime: primes ){
                Integer number = prime * currentNode;
                if ( !unique.contains(number)){
                    unique.add(number);
                    minHeap.add(number);
                }
            }
        }
        return result;
    }
}
