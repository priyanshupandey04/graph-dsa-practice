import java.util.*;

public class CycleDetectionInDGDFS {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = { { 1, 2 }, { 2, 3 }, { 4, 1 }, { 3, 0 } };
        System.out.println(isCyclic(V, edges));
    }

    public static boolean isCyclic(int V, int[][] edges) {
        int nodes = V;
        boolean[] visited = new boolean[nodes];
        boolean[] pathVisited = new boolean[nodes];

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }
        for (int i = 0; i < nodes; i++) {
            if (isCyclic(i, adj, visited, pathVisited)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclic(int node, List<List<Integer>> edges, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        List<Integer> neighbors = edges.get(node);
        for (int i : neighbors) {
            if (visited[i] && pathVisited[i]) {
                return true;
            }
            if (isCyclic(i, edges, visited, pathVisited)) return true;
        }

        pathVisited[node] = false;
        return false;
    }
}
