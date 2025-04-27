package takeUForward.heaps;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

public class P5ImplementMaxHeap {
    List<Integer> maxHeap;
    int count;
    public void initializeHeap() {
        maxHeap = new ArrayList<>();
        count = 0;
    }

    public void insert(int key) {
        maxHeap.add(key);
        heapifyUp(maxHeap, count);
        count++;
    }

    private void heapifyUp(List<Integer> maxHeap, int ind) {
        int parent = ( ind -1)/2;
        if ( ind > 0){
            if ( maxHeap.get(parent) < maxHeap.get(ind)){
                swap(maxHeap, parent, ind);
                heapifyUp(maxHeap, parent);
            }
        }
    }

    public void changeKey(int index, int newVal) {
        if ( index <0 || index >= maxHeap.size()) return;
        if ( newVal > maxHeap.get(index)){
            maxHeap.set(index, newVal);
            heapifyUp(maxHeap, index);
        } else {
            maxHeap.set(index, newVal);
            heapifyDown(maxHeap, index);
        }
    }

    private void heapifyDown(List<Integer> maxHeap, int index) {
        int largeIdx = index;
        int left = 2 * index+1;
        int right = 2 * index+2;
        while ( left < maxHeap.size() && maxHeap.get(left) > maxHeap.get(largeIdx)){
            largeIdx = left;
        }
        while ( right < maxHeap.size() && maxHeap.get(right) > maxHeap.get(largeIdx)){
            largeIdx = right;
        }
        if ( index != largeIdx){
            swap(maxHeap, index, largeIdx);
            heapifyDown(maxHeap, largeIdx);
        }
    }

    public void extractMax() {
        int element = maxHeap.get(0);
        swap(maxHeap, 0, count-1);
        maxHeap.remove(count-1);
        heapifyDown(maxHeap, 0);
        count--;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getMax() {
        return maxHeap.get(0);
    }

    public int heapSize() {
        return count;
    }
}
