package company.google.design;

import java.util.*;

public class P642DesignSearchAutocompleteSystem {
    TrieNode root;
    String prefix;
    public P642DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        for ( int i=0; i<sentences.length; i++){
            addtoTrie(sentences[i], times[i]);
        }
    }

    private void addtoTrie(String sentence, int count) {
        TrieNode current = root;
        for ( char c: sentence.toCharArray()){
            if ( current.children.get(c) == null){
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
            current.counts.put(sentence, current.counts.getOrDefault(sentence,0)+ count);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            addtoTrie(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }
        prefix += c;
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            if (!cur.children.containsKey(ch)) return new ArrayList<>();
            cur = cur.children.get(ch);
        }
        Map<String, Integer> temp = cur.counts;
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> temp.get(a) == temp.get(b) ? b.compareTo(a) : temp.get(a) - temp.get(b));
        for (String key : temp.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > 3) minHeap.poll();
        }

        List<String> res = new ArrayList<>();
        while ( !minHeap.isEmpty()){
            res.addFirst(minHeap.poll());
        }
        return res;
    }

    class TrieNode{
        Map<String, Integer> counts;
        Map<Character, TrieNode> children;

        TrieNode(){
            counts = new HashMap<>();
            children = new HashMap<>();
        }
    }
}
