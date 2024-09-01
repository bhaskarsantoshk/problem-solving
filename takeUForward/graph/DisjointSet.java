package takeUForward.graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    // Lists to hold the parent, rank, and size of each element
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    // Constructor to initialize the Disjoint Set for `n` elements
    public DisjointSet(int n) {
        // Initialize the parent to be the element itself, rank to 0, and size to 1
        for (int i = 0; i <= n; i++) {
            parent.add(i); // Self-parenting (initially, each node is its own parent)
            rank.add(0);   // Initial rank of each node is 0
            size.add(1);   // Initial size of each set is 1
        }
    }

    // Find the ultimate parent of a node with path compression
    public int findUltimateParent(int node) {
        if (node == parent.get(node)) return node; // If node is its own parent, return it
        else {
            // Path compression: Recursively find the ultimate parent and update the parent list
            int uParent = findUltimateParent(parent.get(node));
            parent.set(node, uParent); // Update the parent of the node to the ultimate parent
            return parent.get(node);
        }
    }

    // Union two sets by rank
    public void unionByRank(int u, int v) {
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);

        // If both nodes have the same ultimate parent, they are already in the same set
        if (ultimateParentU == ultimateParentV) return;

        // Attach the tree with lower rank under the tree with higher rank
        if (rank.get(ultimateParentU) < rank.get(ultimateParentV)) {
            parent.set(ultimateParentU, ultimateParentV);
        } else if (rank.get(ultimateParentV) < rank.get(ultimateParentU)) {
            parent.set(ultimateParentV, ultimateParentU);
        } else {
            // If ranks are equal, arbitrarily attach one to the other and increase its rank
            parent.set(ultimateParentV, ultimateParentU);
            int rankU = rank.get(ultimateParentU);
            rank.set(ultimateParentU, rankU + 1);
        }
    }

    // Union two sets by size
    public void unionBySize(int u, int v) {
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);

        // If both nodes have the same ultimate parent, they are already in the same set
        if (ultimateParentU == ultimateParentV) return;

        // Attach the smaller tree under the larger tree
        if (size.get(ultimateParentU) < size.get(ultimateParentV)) {
            parent.set(ultimateParentU, ultimateParentV);
            size.set(ultimateParentV, size.get(ultimateParentV) + size.get(ultimateParentU));
        } else {
            parent.set(ultimateParentV, ultimateParentU);
            size.set(ultimateParentU, size.get(ultimateParentV) + size.get(ultimateParentU));
        }
    }

    // Test cases to demonstrate the functionality of the Disjoint Set
    public static void main(String[] args) {
        int n = 7; // Number of elements in the set

        DisjointSet ds = new DisjointSet(n);

        // Perform union operations
        ds.unionBySize(1, 2); // Union elements 1 and 2 by size
        ds.unionBySize(2, 3); // Union elements 2 and 3 by size
        ds.unionByRank(4, 5); // Union elements 4 and 5 by rank
        ds.unionByRank(6, 7); // Union elements 6 and 7 by rank
        ds.unionBySize(5, 6); // Union elements 5 and 6 by size
        ds.unionBySize(3, 7); // Union elements 3 and 7 by size

        // Check if 3 and 7 are in the same set (should be true)
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("3 and 7 are in the same set.");
        } else {
            System.out.println("3 and 7 are not in the same set.");
        }

        // Check if 1 and 5 are in the same set (should be false)
        if (ds.findUltimateParent(1) == ds.findUltimateParent(5)) {
            System.out.println("1 and 5 are in the same set.");
        } else {
            System.out.println("1 and 5 are not in the same set.");
        }

        // Perform additional union and checks
        ds.unionByRank(1, 5); // Union elements 1 and 5 by rank

        // Now check if 1 and 5 are in the same set (should be true)
        if (ds.findUltimateParent(1) == ds.findUltimateParent(5)) {
            System.out.println("1 and 5 are now in the same set.");
        } else {
            System.out.println("1 and 5 are still not in the same set.");
        }
    }
}