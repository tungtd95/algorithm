package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class JackGoToRapture {
    ArrayList<HashSet<Edge>> graph = new ArrayList<>();
    ArrayList<Integer> costTracker = new ArrayList<>();

    public void getCost(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        // construct graph
        for (int i = 0; i <= gNodes; i++) {
            graph.add(new HashSet<>());
            costTracker.add(Integer.MAX_VALUE);
        }
        for (int i = 0; i < gFrom.size(); i++) {
            graph.get(gFrom.get(i)).add(new Edge(gTo.get(i), gWeight.get(i)));
            graph.get(gTo.get(i)).add(new Edge(gFrom.get(i), gWeight.get(i)));
        }

        // start dfs
        costTracker.set(1, 0);
        visit(1, gNodes);
        if (costTracker.get(gNodes) == Integer.MAX_VALUE) {
            System.out.println("NO PATH EXISTS");
        } else {
            System.out.println(costTracker.get(gNodes));
        }
    }

    private void visit(int vertex, int gNodes) {
        HashSet<Edge> adj = graph.get(vertex);
        for (Edge e : adj) {
            int costFromVertexToEdge = Math.max(costTracker.get(vertex), e.weight);
            int currentCostOfEdge = costTracker.get(e.to);
            if (currentCostOfEdge > costFromVertexToEdge) {
                costTracker.set(e.to, costFromVertexToEdge);
                if (e.to != gNodes) {
                    visit(e.to, gNodes);
                }
            }
        }
    }

    class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return to == edge.to && weight == edge.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(to, weight);
        }
    }
}
