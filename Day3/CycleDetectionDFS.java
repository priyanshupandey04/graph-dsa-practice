
import java.util.*;

public class CycleDetectionDFS {
    public static void main(String[] args) {
        int V = 4;
        int E = 4;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };
        CycleDetectionDFS cycle = new CycleDetectionDFS();
        System.out.println(cycle.isCycle(V, edges));

    }

    public boolean isCycle(int V, int[][] edges) {
        int nodes = V;
        boolean[] visited = new boolean[nodes];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                if (dfs(visited, adj, i, -1)) return true;
            }
        }
        return false;
    }

    public boolean dfs(boolean[] visited, ArrayList<ArrayList<Integer>> adj, int node, int parent) {
        visited[node] = true;
        ArrayList<Integer> neighbours = adj.get(node);
        for (Integer v : neighbours) {
            if (!visited[v]) {
                if (dfs(visited, adj, v, node)) return true;
            } else if (v != parent) {
                return true;
            }
        }

        return false;
    }
}
