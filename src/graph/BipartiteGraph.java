package graph;

import java.util.ArrayList;

public class BipartiteGraph {

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // init
        int[] tracker = new int[V];
        ArrayList<Integer> toVisit = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            tracker[i] = 0;
        }

        // start bfs
        for (int v = 0; v < V; v ++) {
            if (tracker[v] != 0) {
                continue;
            }
            toVisit.add(v);
            tracker[v] = 1; // start from 0, color it by 1
            while (!toVisit.isEmpty()) {
                int currentVertex = toVisit.remove(0);
                int currentColor = tracker[currentVertex];
                int adjColor = 1;
                if (currentColor == 1) {
                    adjColor = 2;
                }
                ArrayList<Integer> currentAdj = adj.get(currentVertex);
                for (int vertex : currentAdj) {
                    // check if this vertex is colored
                    if (tracker[vertex] == currentColor) {
                        return false;
                    }
                    // this vertex is not discovered yet
                    if (tracker[vertex] == 0) {
                        toVisit.add(vertex);
                        tracker[vertex] = adjColor;
                    }
                }
            }
        }
        return true;
    }
}
