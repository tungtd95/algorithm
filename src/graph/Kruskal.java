package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static long kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < gFrom.size(); i++) {
            edges.add(new Edge(gFrom.get(i) - 1, gTo.get(i) - 1, gWeight.get(i)));
        }
        Collections.sort(edges);
        ArrayList<Integer> parentTracker = new ArrayList<>();
        for (int i = 0; i < gNodes; i++) {
            parentTracker.add(i);
        }

        long mst = 0;
        for (Edge edge : edges) {
            int rootU = findRoot(edge.u, parentTracker);
            int rootV = findRoot(edge.v, parentTracker);
            if (rootU == rootV) continue;
            parentTracker.set(rootV, rootU);
            mst += edge.w;
        }

        return mst;
    }

    private static int findRoot(int vertex, ArrayList<Integer> parentTracker) {
        if (parentTracker.get(vertex) == vertex) return vertex;
        return findRoot(parentTracker.get(vertex), parentTracker);
    }

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
}
