package takeUForward.tries;

public class P5MaximumXOROfTwoNumbersInAnArray {
    static class TrieNode{
        TrieNode[] children = new TrieNode[2];

        public TrieNode(){

        }

        TrieNode get(int bit){
            return this.children[bit];
        }

        void put(int bit, TrieNode node){
            this.children[bit] = node;
        }

        boolean containsKey(int bit){
            return this.children[bit] != null;
        }
    }

    TrieNode root;

    P5MaximumXOROfTwoNumbersInAnArray(){
        root = new TrieNode();
    }

    void insert(int num){
        TrieNode node = root;
        for ( int i=31; i>=0; i--){
            int bit = ( num >> i ) & 1;
            if ( !node.containsKey(bit)){
                node.put(bit, new TrieNode());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num){
        TrieNode node = root;
        int max = 0;
        for ( int i=31; i>=0; i--){
            int bit = ( num >> i ) & 1;
            if ( node.containsKey(1-bit)){
                max = max | ( 1 << i);
                node = node.get(1-bit);
            } else {
                node = node.get(bit);
            }
        }
        return max;
    }

    public int findMaximumXOR(int[] nums) {
        for ( int num: nums){
            insert(num);
        }
        int max = 0;
        for ( int num: nums){
            max = Math.max( max, getMax(num));
        }
        return max;
    }
}
