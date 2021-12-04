package graph;

import java.util.ArrayList;
import java.util.HashSet;

public class BFSofGraph {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> vertexToVisit = new ArrayList<>();
        HashSet<Integer> vertexVisited = new HashSet<>();

        ArrayList<Integer> result = new ArrayList<>();

        vertexToVisit.add(0);
        vertexVisited.add(0);
        result.add(0);
        while (!vertexToVisit.isEmpty()) {
            int currentVertex = vertexToVisit.remove(0);
            ArrayList<Integer> currentAdj = adj.get(currentVertex);
            for (int vertex : currentAdj) {
                if (!vertexVisited.contains(vertex)) {
                    vertexToVisit.add(vertex);
                    vertexVisited.add(vertex);
                    result.add(vertex);
                }
            }
        }
        return result;
    }
}
