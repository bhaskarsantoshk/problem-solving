package CrackingTheCodingInterview.TreesAndGraphs;

public class Node {
    public String name;
    public Node[] children;
    public RouteBetweenNodes.State state;

    public Node[] getAdjacent() {
        return this.children;
    }
}
