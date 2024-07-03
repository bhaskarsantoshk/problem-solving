# Merging Intervals Solution Summary

1. **Sort Intervals**:
   - Sort intervals based on starting values.

2. **Initialize**:
   - Create a result list `res`.
   - Add the first interval to `res`.

3. **Merge Intervals**:
   - Iterate through intervals:
     - If overlapping (`newInterval[1] >= interval[0]`), merge by updating end.
     - If not overlapping, add the interval to `res`.

4. **Convert to Array**:
   - Convert `res` to a 2D array for the result.
  
```Java
public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a1,a2)-> Integer.compare(a1[0],a2[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int newInterval[] = intervals[0];
        for ( int [] interval : intervals){
            if ( newInterval[1] >= interval[0] ){
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
```
  
