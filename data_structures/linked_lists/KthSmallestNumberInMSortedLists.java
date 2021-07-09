package data_structures.linked_lists;

import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestNumberInMSortedLists {
    public static int findKthSmallest(List<Integer[]> lists, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
                (n1,n2) -> lists.get(n1.arrayIndex)[n1.elementIndex]-lists.get(n2.arrayIndex)[n2.elementIndex]
        );
        for (int i=0; i<lists.size(); i++){
            if (lists.get(i) != null){
                minHeap.offer(new Node(0,i));
            }
        }
        int count = 0, res = 0;
        while ( !minHeap.isEmpty()){
            Node node = minHeap.poll();
            res = lists.get(node.arrayIndex)[node.elementIndex];
            count++;
            if ( count == k){
                break;
            }
            node.elementIndex++;
            if (lists.get(node.arrayIndex).length > node.elementIndex){
                minHeap.add(node);
            }
        }
        return res;
    }


    static class Node {
        int elementIndex;
        int arrayIndex;

        Node(int elementIndex, int arrayIndex) {
            this.elementIndex = elementIndex;
            this.arrayIndex = arrayIndex;
        }
    }
}
