package takeUForward.heaps.revision;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

public class P4ImplementMinHeap {
    List<Integer> minHeap ;
    int count;

    public void initializeHeap() {
        this.minHeap = new ArrayList<>();
        this.count = 0;
    }

    public void insert(int key) {
        minHeap.add(key);
        heapifyUp(minHeap, count);
        count++;
    }

    private void heapifyUp(List<Integer> arr, int ind) {
        int parent = (ind-1)/2;
        if ( ind > 0){
            if ( arr.get(parent) > arr.get(ind)){
                swap(arr, parent, ind);
                heapifyUp(arr, parent);
            }
        }
    }

    public void changeKey(int index, int newVal) {
        if ( index < 0 || index >= minHeap.size()) return;
        if ( minHeap.get(index) < newVal){
            minHeap.set(index, newVal);
            heapifyDown(minHeap, index);
        } else {
            minHeap.set(index, newVal);
            heapifyUp(minHeap, index);
        }
    }

    public void extractMin() {
        int element = minHeap.get(0);
        swap(minHeap, 0, count-1);
        minHeap.remove(count-1);
        heapifyDown(minHeap, 0);
        count--;
    }

    private void heapifyDown(List<Integer> minHeap, int ind) {
        int smallIdx = ind;
        int left = 2 * ind +1;
        int right = 2 * ind+2;
        if ( left < minHeap.size() && minHeap.get(left) < minHeap.get(smallIdx)){
            smallIdx = left;
        }
        if ( right < minHeap.size() && minHeap.get(right) < minHeap.get(smallIdx)){
            smallIdx = right;
        }
        if ( smallIdx != ind){
            swap(minHeap, ind, smallIdx);
            heapifyDown(minHeap, smallIdx);
        }
    }

    public boolean isEmpty() {
        return count==0;
    }

    public int getMin() {
        return minHeap.get(0);
    }

    public int heapSize() {
        return count;
    }
}
