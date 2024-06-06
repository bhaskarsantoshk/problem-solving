class MergeOverlappingSubIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a1,a2)-> Integer.compare(a1[0], a2[0]));
        List<int[]> res = new ArrayList<>();
        int newInterval[] = intervals[0];
        res.add(newInterval);
        for ( int[] interval : intervals){
            if ( newInterval[1] >= interval[0]){
                newInterval[1] = Math.max( newInterval[1], interval[1]);
            } else {
                newInterval= interval;
                res.add(newInterval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
