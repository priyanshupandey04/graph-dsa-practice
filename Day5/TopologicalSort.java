
import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        int V = 6;
        int[][] edges = { { 1, 3 }, { 2, 3 }, { 4, 1 }, { 4, 0 }, { 5, 0 }, { 5, 2 } };
        System.out.println(topoSort(V, edges));
    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        int nodes = V;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[nodes];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nodes; i++) {
            if (!visited[i])
                dfs(i, adj, visited, stack);
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while (!stack.isEmpty()) {
            topo.add(stack.pop());
        }
        return topo;
    }

    private static void dfs(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        List<Integer> neighbors = adj.get(node);
        for (Integer i : neighbors) {
            if (!visited[i])
                dfs(i, adj, visited, stack);
        }

        stack.push(node);
    }
}
