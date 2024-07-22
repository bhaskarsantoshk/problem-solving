package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class P2418SortThePeople {

    // Approach 1
    public String[] sortPeopleBruteForce(String[] names, int[] heights) {
        Pair[] person = new Pair[names.length];
        for ( int i=0; i<names.length; i++){
            person[i] = new Pair(names[i], heights[i]);
        }
        Arrays.sort(person, (p1,p2)->p1.height- p2.height);
        String[] sortedNames = new String[names.length];
        for (int i = 0; i < person.length; i++) {
            sortedNames[i] = person[i].name;
        }

        return sortedNames;
    }

    class Pair{
        String name;
        int height;

        public Pair(String name, int height) {
            this.name = name;
            this.height= height;
        }
    }

    // Approach 2
    // Use map to create (height , name) key value pair
    // works if the heights are distinct
    // sort heights and create a result array

    // Approach 3, use Treemap

    // Approach 4
    // Sorted indices
    public String[] sortPeople(String[] names, int[] heights) {
        Integer [] sortedIndices = new Integer[names.length];
        for ( int i=0; i<names.length; i++){
            sortedIndices[i] = i;
        }
        Arrays.sort(sortedIndices, (a,b)-> heights[b]-heights[a]);
        String[] sortedNames = new String[names.length];
        for ( int i=0; i<names.length; i++){
            sortedNames[i] = names[sortedIndices[i]];
        }
        return sortedNames;
    }

    // Approach 5
    // Merge sort

    public String[] sortPeopleUsingMergeSort(String[] names, int[] heights) {
        mergeSort(names, heights, 0, names.length-1);
        return names;
    }

    private void mergeSort(String[] names, int[] heights, int start, int end) {
        if ( start < end ){
            int mid = start + (end-start)/2;
            mergeSort(names, heights, start, mid);
            mergeSort(names, heights, mid+1, end);
            merge(names, heights, start, mid, end);
        }
    }

    private void merge(String[] names, int[] heights, int start, int mid, int end) {
        int leftSize = mid-start+1;
        int rightSize = end - mid;

        int leftHeights[] = new int[leftSize];
        int rightHeights[] = new int[rightSize];
        String leftNames[] = new String[leftSize];
        String rightNames[] = new String[rightSize];

        for ( int i=0; i<leftSize; i++){
            leftHeights[i] = heights[start+i];
            leftNames[i] = names[start+i];
        }
        for ( int j=0; j<rightSize; j++){
            rightHeights[j] = heights[mid+1+j];
            rightNames[j] = names[mid+1+j];
        }

        int leftIndex = 0, rightIndex=0;
        int mergeIndex = 0;

        while ( leftIndex < leftSize && rightIndex < rightSize){
            if ( leftHeights[leftIndex] < rightHeights[rightIndex]){
                heights[mergeIndex] = leftHeights[leftIndex];
                names[mergeIndex] = leftNames[leftIndex];
                leftIndex++;
            } else {
                heights[mergeIndex] = rightHeights[rightIndex];
                names[mergeIndex] = rightNames[rightIndex];
                rightIndex++;
            }
            mergeIndex++;
        }
        while ( leftIndex < leftSize){
            heights[mergeIndex] = leftHeights[leftIndex];
            names[mergeIndex] = leftNames[leftIndex];
            leftIndex++;
            mergeIndex++;
        }
        while ( leftIndex < rightIndex){
            heights[mergeIndex++] = rightHeights[rightIndex++];
            names[mergeIndex] = rightNames[rightIndex];
            rightIndex++;
            mergeIndex++;
        }
    }

}
