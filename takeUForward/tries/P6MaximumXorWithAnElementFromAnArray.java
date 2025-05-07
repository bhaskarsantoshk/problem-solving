package takeUForward.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P6MaximumXorWithAnElementFromAnArray {

    TrieNode root = new TrieNode();

    public List<Integer> maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int[][] queriesWithIndex= new int[queries.length][3];
        for ( int i=0; i<queries.length; i++){
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = i;
        }
        Arrays.sort(queriesWithIndex, (a,b)-> a[1]-b[1]);
        List<Integer> result = new ArrayList<>(Collections.nCopies(queries.length, -1));
        int index = 0;
        for (int[] query : queriesWithIndex) {
            int x = query[0];
            int m = query[1];
            while ( index < nums.length) {
                if (nums[index] <= m) {
                    insert(nums[index]);
                    index++;
                } else {
                    break;
                }
            }
            int maxXor = getMax(x);
            result.set(query[2], maxXor);
        }
        return result;
    }

    private void insert(int num) {
        TrieNode node = root;
        for ( int i=31; i>=0; i--){
            int bit = (num >> i) & 1;
            if ( !node.containsKey(bit)){
                node.put(bit, new TrieNode());
            }
            node = node.get(bit);
        }
    }

    private int getMax(int x) {
        TrieNode node = root;
        int max = 0;
        for ( int i=31; i>=0; i--){
            int bit = (x >> i) & 1;
            if ( node.containsKey(1-bit)){
                max = max | (1<<i);
                node = node.get(1-bit);
            } else {
                node = node.get(bit);
            }
        }
        return max;
    }


    static class TrieNode{
        TrieNode[] children = new TrieNode[2];

        public boolean containsKey(int bit) {
            return this.children[bit] != null;
        }

        public TrieNode get(int bit) {
            return this.children[bit];
        }

        public void put(int bit, TrieNode trieNode) {
            this.children[bit] = trieNode;
        }
    }
}
