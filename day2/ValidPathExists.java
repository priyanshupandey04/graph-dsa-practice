import java.util.*;

public class ValidPathExists {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 0, 4 } };
        int source = 0;
        int destination = 4;
        System.out.println(validPath(n, edges, source, destination));
    }

    static public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        return DFS(adj, source, destination);
    }

    static boolean DFS(ArrayList<ArrayList<Integer>> adj, int source, int destination) {
        int nodes = adj.size();
        boolean[] visited = new boolean[nodes];
        ArrayList<Integer> dfs = new ArrayList<>();
        dfs(source, adj, dfs, visited);
        return visited[source] && visited[destination];
    }

    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs, boolean[] visited) {
        visited[node] = true;
        dfs.add(node);
        ArrayList<Integer> neighbour = adj.get(node);
        for (Integer v : neighbour) {
            if (!visited[v]) {
                dfs(v, adj, dfs, visited);
            }
        }
    }

}
