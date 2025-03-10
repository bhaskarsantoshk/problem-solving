package takeUForward.blind75.linkedlists;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2)-> node1.value-node2.value);
        for ( int i=0; i<kArrays.size(); i++){
            pq.offer(new Node(i, 0, kArrays.get(i).get(0)));
        }
        while ( !pq.isEmpty()){
            Node node = pq.poll();
            result.add(node.value);
            int newValueIndex = node.valueIndex+1;
            if ( newValueIndex < kArrays.get(node.arrayIndex).size()){
                Node newNode = new Node(node.arrayIndex, newValueIndex, kArrays.get(node.arrayIndex).get(newValueIndex));
                pq.add(newNode);
            }
        }
        return result;
    }

    static class Node{
        int arrayIndex;
        int valueIndex;
        int value;

        Node(int arrayIndex, int valueIndex, int value){
            this.arrayIndex = arrayIndex;
            this.valueIndex = valueIndex;
            this.value = value;
        }
    }
}
