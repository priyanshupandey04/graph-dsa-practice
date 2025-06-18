import java.util.*;

public class FindNumberOfComponent {

    static public int findNumberOfComponent(int V, List<List<Integer>> adj) {
        int nodes = V, numOfComp = 0;
        boolean[] visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                numOfComp++;
                DFS(adj, visited, i);
            }
        }
        return numOfComp;
    }

    static void DFS(List<List<Integer>> adj, boolean[] vis, int startingNode) {
        int nodes = adj.size();
        boolean[] visited = new boolean[nodes];
        ArrayList<Integer> dfs = new ArrayList<>();
        dfs(startingNode, adj, dfs, vis);
    }

    static void dfs(int node, List<List<Integer>> adj, ArrayList<Integer> dfs, boolean[] visited) {
        visited[node] = true;
        dfs.add(node);
        List<Integer> neighbour = adj.get(node);
        for (Integer v : neighbour) {
            if (!visited[v]) {
                dfs(v, adj, dfs, visited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = 7;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(4).add(5);
        adj.get(5).add(4);
        System.out.println("findNumberOfComponent = " + findNumberOfComponent(V, adj));
    }

}