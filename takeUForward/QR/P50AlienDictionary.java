import java.util.*;

class P50AlienDictionary {
    
    /* Function to return the topological
     sorting of given graph */
    private List<Integer> topoSort(int V, List<Integer>[] adj) {
        
        // To store the In-degrees of nodes
        int[] inDegree = new int[V];
        
        // Update the in-degrees of nodes
        for (int i = 0; i < V; i++) {
            
            for (int it : adj[i]) {
                // Update the in-degree
                inDegree[it]++;
            }
        }
        
        // To store the result
        List<Integer> ans = new ArrayList<>();
        
        // Queue to facilitate BFS
        Queue<Integer> q = new LinkedList<>();
        
        // Add the nodes with no in-degree to queue
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        
        // Until the queue is empty
        while (!q.isEmpty()) {
            
            // Get the node
            int node = q.poll();
            
            // Add it to the answer
            ans.add(node);
            
            // Traverse the neighbours
            for (int it : adj[node]) {
                
                // Decrement the in-degree
                inDegree[it]--;
                
                /* Add the node to queue if 
                its in-degree becomes zero */
                if (inDegree[it] == 0) q.add(it);
            }
        }
        
        // Return the result
        return ans;
    }
    
    /* Function to determine order of 
    letters based on alien dictionary */
    public String findOrder(String[] dict, int N, int K) {
        
        // Initialise a graph of K nodes
        List<Integer>[] adj = new ArrayList[K];
        for (int i = 0; i < K; i++) adj[i] = new ArrayList<>();
        
        // Compare the consecutive words
        for (int i = 0; i < N - 1; i++) {
            
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            
            /* Compare the pair of strings letter by 
            letter to identify the differentiating letter */
            for (int ptr = 0; ptr < len; ptr++) {
                
                // If the differentiating letter is found
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    
                    // Add the edge to the graph
                    adj[s1.charAt(ptr) - 'a'].add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        
        /* Get the topological sort 
        of the graph formed */
        List<Integer> topo = topoSort(K, adj);
        
        // To store the answer
        StringBuilder ans = new StringBuilder();
        
        for (int i = 0; i < K; i++) {
            // Add the letter to the result
            ans.append((char) ('a' + topo.get(i)));
            ans.append(' ');
        }
        
        // Return the answer
        return ans.toString();
    }
    
    public static void main(String[] args) {
        
        int N = 5, K = 4;
        String[] dict = {
            "baa", "abcd", "abca", "cab", "cad"
        };
        
        /* Creating an instance of 
        Solution class */
        Solution sol = new Solution();
        
        /* Function call to determine order of 
        letters based on alien dictionary */
        String ans = sol.findOrder(dict, N, K);
        
        // Output
        System.out.println("The order to characters as per alien dictionary is: " + ans);
    }
}
