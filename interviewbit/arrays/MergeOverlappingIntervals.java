package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverlappingIntervals {

    class Interval{
        int start;
        int end;
        Interval(){
            start =0;
            end = 0;
        }
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> mergedIntervals = new ArrayList<>();
        if (intervals.size()==0){
            return null;
        }
        Stack<Interval> stack = new Stack<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        stack.push(intervals.get(0));
        for(int i=1; i<intervals.size(); i++){
            Interval top = stack.peek();

            if(top.end < intervals.get(i).start){
                stack.push(intervals.get(i));
            }
            else if(top.end < intervals.get(i).end){
                top.end =  intervals.get(i).end;
                stack.pop();
                stack.push(top);
            }
        }
        while(!stack.isEmpty()){
            mergedIntervals.add(stack.pop());
        }
        Collections.sort(mergedIntervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2){
                return o1.start-o2.start;
            }
        });
        return mergedIntervals;
    }
}
