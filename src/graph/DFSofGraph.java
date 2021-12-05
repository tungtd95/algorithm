package graph;

import java.util.ArrayList;
import java.util.HashSet;

public class DFSofGraph {
    private final HashSet<Integer> visited = new HashSet<>();
    private final ArrayList<Integer> travelPath = new ArrayList<>();

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        visit(0, adj);
        return travelPath;
    }

    private void visit(int vertex, ArrayList<ArrayList<Integer>> adj) {
        visited.add(vertex);
        travelPath.add(vertex);
        for (int v : adj.get(vertex)) {
            if (!visited.contains(v)) {
                visit(v, adj);
            }
        }
    }
}
