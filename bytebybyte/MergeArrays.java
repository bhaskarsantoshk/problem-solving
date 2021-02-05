package bytebybyte;

public class MergeArrays {

    public void merge (int a[], int b[], int aLength, int bLength) throws Exception {
        if ( a.length < aLength + bLength ){
            throw new Exception();
        }
        int aIndex = aLength-1;
        int bIndex = bLength-1;
        int mergeIndex = aLength+bLength-1;

        while ( aIndex >= 0 && bIndex >=0){
            if ( a[aIndex] > b[bIndex]){
                a[mergeIndex] = a[aIndex];
                aIndex--;
            }
            else{
                a[mergeIndex] = b[bIndex];
                bIndex--;
            }
            mergeIndex--;
        }

        while ( bIndex >= 0){
            a[mergeIndex--] = b[bIndex--];
        }

    }

}

// given two sorted arrays A and B and A is long enough to hold the contents of A and B
// A = [1,3,5,0,0,0]
// B = [2,4,6]
// A = [1,2,3,4,5,6]
//  we cannot use additional memory
// merge sort technique - we can't use as we don't have an auxiliary array
// we shift all zeros to the front - and then use merge technique


// most efficient solution:
// applying merge technique backwards

// A = [1,3,5,0,0,0]
//          ^     ^
// B = [2,4,6]
//          ^
