class P846HandofStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for ( int num: hand ){
            minHeap.add(num);
        }

        while ( minHeap.size() != 0){
            int start = minHeap.poll();
            for ( int count=1; count<groupSize; count++){
                if ( !minHeap.remove(start+count)){
                    return false;
                } 
            }
        }
        return true;
    }
}
